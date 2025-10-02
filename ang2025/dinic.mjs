// Dinic O(E * V^2) general, O(E * sqrt(V)) aprox. en bipartitos
export class Dinic {
  constructor(n) {
    this.n = n;
    this.adj = Array.from({ length: n }, () => []);
  }
  // añade arista u->v con capacidad cap (y la residual v->u con 0)
  addEdge(u, v, cap) {
    const a = { to: v, cap, rev: null };
    const b = { to: u, cap: 0, rev: a };
    a.rev = b;
    this.adj[u].push(a);
    this.adj[v].push(b);
  }

  #bfsLevel(s, t) {
    this.level = Array(this.n).fill(-1);
    const q = [s];
    this.level[s] = 0;
    for (let i = 0; i < q.length; i++) {
      const u = q[i];
      for (const e of this.adj[u]) if (e.cap > 0 && this.level[e.to] < 0) {
        this.level[e.to] = this.level[u] + 1;
        q.push(e.to);
      }
    }
    return this.level[t] >= 0;
  }

  #dfsBlocking(u, t, f, itIdx) {
    if (u === t) return f;
    for (; itIdx[u] < this.adj[u].length; itIdx[u]++) {
      const e = this.adj[u][itIdx[u]];
      if (e.cap > 0 && this.level[u] + 1 === this.level[e.to]) {
        const pushed = this.#dfsBlocking(e.to, t, Math.min(f, e.cap), itIdx);
        if (pushed > 0) {
          e.cap -= pushed;
          e.rev.cap += pushed;
          return pushed;
        }
      }
    }
    return 0;
  }

  maxFlow(s, t) {
    let flow = 0;
    while (this.#bfsLevel(s, t)) {
      const itIdx = Array(this.n).fill(0);
      while (true) {
        const pushed = this.#dfsBlocking(s, t, Number.POSITIVE_INFINITY, itIdx);
        if (pushed === 0) break;
        flow += pushed;
      }
    }
    return flow;
  }
}

/* Ejemplo (matching bipartito):
// L = {0,1}, R = {2,3}; s=4, t=5
const din = new Dinic(6);
const s = 4, t = 5;
// s->L
din.addEdge(s, 0, 1);
din.addEdge(s, 1, 1);
// L->R (posibles emparejamientos)
din.addEdge(0, 2, 1);
din.addEdge(0, 3, 1);
din.addEdge(1, 3, 1);
// R->t
din.addEdge(2, t, 1);
din.addEdge(3, t, 1);

console.log("Max flow / matching size:", din.maxFlow(s, t)); // 2
*/
