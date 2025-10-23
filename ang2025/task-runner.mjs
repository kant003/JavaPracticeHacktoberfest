/**
 * TaskRunner: ejecuta tareas con dependencias (DAG) en paralelo.
 * - Detecta ciclos (si hay, lanza error).
 * - Concurrencia configurable.
 * - Reintentos con backoff exponencial.
 *
 * tasks: {
 *   id: string,
 *   deps: string[],
 *   run: () => Promise<any>,
 *   retries?: number,        // por defecto 0
 *   backoffMs?: number       // base del backoff, por defecto 250
 * }[]
 */
export class TaskRunner {
  constructor(tasks, { concurrency = 4 } = {}) {
    this.tasks = new Map(tasks.map(t => [t.id, { ...t, retries: t.retries ?? 0, backoffMs: t.backoffMs ?? 250 }]));
    this.concurrency = concurrency;
    this._checkDag();
  }

  _checkDag() {
    const inDeg = new Map([...this.tasks.keys()].map(k => [k, 0]));
    for (const { deps } of this.tasks.values()) {
      for (const d of deps) {
        if (!this.tasks.has(d)) throw new Error(`Dependencia desconocida: ${d}`);
        inDeg.set(d, inDeg.get(d));
      }
    }
    for (const t of this.tasks.values()) {
      for (const d of t.deps) inDeg.set(t.id, (inDeg.get(t.id) ?? 0) + 1);
    }
    // Kahn: si no procesamos todas => ciclo
    const q = [...[...inDeg.entries()].filter(([,v]) => v === 0).map(([k]) => k)];
    let cnt = 0;
    const g = new Map([...this.tasks.values()].map(t => [t.id, new Set()]));
    for (const t of this.tasks.values()) for (const d of t.deps) g.get(d).add(t.id);
    while (q.length) {
      const u = q.shift(); cnt++;
      for (const v of g.get(u)) {
        inDeg.set(v, inDeg.get(v) - 1);
        if (inDeg.get(v) === 0) q.push(v);
      }
    }
    if (cnt !== this.tasks.size) throw new Error("El grafo de dependencias tiene ciclos.");
  }

  async runAll() {
    const inDeg = new Map([...this.tasks.keys()].map(k => [k, 0]));
    for (const t of this.tasks.values()) for (const d of t.deps) inDeg.set(t.id, (inDeg.get(t.id) ?? 0) + 1);

    const children = new Map([...this.tasks.keys()].map(k => [k, []]));
    for (const t of this.tasks.values()) for (const d of t.deps) children.get(d).push(t.id);

    const results = new Map();
    const errors = new Map();

    const ready = [...[...inDeg.entries()].filter(([,v]) => v === 0).map(([k]) => k)];
    const running = new Set();

    const launch = async (id) => {
      running.add(id);
      const task = this.tasks.get(id);
      const res = await this._runWithRetry(task).catch(e => {
        errors.set(id, e);
        return undefined;
      });
      if (res !== undefined) results.set(id, res);
      running.delete(id);
      // Desbloquear hijos solo si no hubo error en esta rama
      if (!errors.has(id)) {
        for (const ch of children.get(id)) {
          inDeg.set(ch, inDeg.get(ch) - 1);
          if (inDeg.get(ch) === 0) ready.push(ch);
        }
      } else {
        // Propagar bloqueo: los hijos nunca alcanzarán inDeg==0 limpio si dependen de fallida
        for (const ch of children.get(id)) {
          errors.set(ch, new Error(`Bloqueado por fallo de dependencia: ${id}`));
        }
      }
    };

    // Loop principal de scheduling
    while (ready.length || running.size) {
      while (running.size < this.concurrency && ready.length) {
        const id = ready.shift();
        if (errors.has(id)) continue; // bloqueado por fallo
        launch(id);
      }
      await Promise.race([
        new Promise(r => setTimeout(r, 10)),
        ...(Array.from(running).map(() => new Promise(r => setTimeout(r, 10))))
      ]);
    }

    if (errors.size) {
      const err = new Error("Algunas tareas fallaron.");
      err.details = Object.fromEntries([...errors.entries()].map(([k, e]) => [k, e.message]));
      throw err;
    }
    return Object.fromEntries(results);
  }

  async _runWithRetry(task) {
    let attempt = 0, lastErr;
    while (attempt <= task.retries) {
      try { return await task.run(); }
      catch (e) {
        lastErr = e; attempt++;
        if (attempt > task.retries) break;
        const backoff = task.backoffMs * (2 ** (attempt - 1));
        await new Promise(r => setTimeout(r, backoff));
      }
    }
    throw lastErr;
  }
}

/* Ejemplo de uso:
const runner = new TaskRunner([
  { id: "A", deps: [], run: async () => "ok A" },
  { id: "B", deps: ["A"], run: async () => "ok B" },
  { id: "C", deps: ["A"], run: async () => { throw new Error("fail C"); }, retries: 2, backoffMs: 200 },
  { id: "D", deps: ["B","C"], run: async () => "ok D" },
], { concurrency: 2 });

runner.runAll().then(console.log).catch(e => console.error(e.message, e.details));
*/
