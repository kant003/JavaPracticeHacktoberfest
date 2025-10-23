/**
 * LWW-Element-Set CRDT:
 * - addSet:   Map<element, timestamp>
 * - removeSet:Map<element, timestamp>
 * - has(x):   true si ts_add > ts_remove
 * - merge:    combina tomándose el max timestamp por clave
 */
export class LWWSet {
  constructor() {
    this.addSet = new Map();
    this.removeSet = new Map();
  }

  // Opcional: permitir timestamps externos para relojes lógicos/híbridos (HLC)
  add(element, ts = Date.now()) {
    const prev = this.addSet.get(element) ?? -Infinity;
    if (ts > prev) this.addSet.set(element, ts);
  }
  remove(element, ts = Date.now()) {
    const prev = this.removeSet.get(element) ?? -Infinity;
    if (ts > prev) this.removeSet.set(element, ts);
  }

  has(element) {
    const ta = this.addSet.get(element) ?? -Infinity;
    const tr = this.removeSet.get(element) ?? -Infinity;
    return ta > tr;
  }

  values() {
    const out = [];
    const keys = new Set([...this.addSet.keys(), ...this.removeSet.keys()]);
    for (const k of keys) if (this.has(k)) out.push(k);
    return out;
  }

  merge(other) {
    const res = new LWWSet();
    // merge addSet
    for (const [k, v] of this.addSet) res.addSet.set(k, v);
    for (const [k, v] of other.addSet) {
      const prev = res.addSet.get(k) ?? -Infinity;
      if (v > prev) res.addSet.set(k, v);
    }
    // merge removeSet
    for (const [k, v] of this.removeSet) res.removeSet.set(k, v);
    for (const [k, v] of other.removeSet) {
      const prev = res.removeSet.get(k) ?? -Infinity;
      if (v > prev) res.removeSet.set(k, v);
    }
    return res;
  }

  // Serialización simple
  toJSON() {
    return {
      add: [...this.addSet.entries()],
      rem: [...this.removeSet.entries()]
    };
  }
  static fromJSON(obj) {
    const s = new LWWSet();
    s.addSet = new Map(obj.add);
    s.removeSet = new Map(obj.rem);
    return s;
  }
}

/* Ejemplo:
const a = new LWWSet();
const b = new LWWSet();

// Réplica A
a.add("alice", 1000);
a.add("bob", 1005);
a.remove("alice", 1010);

// Réplica B
b.add("alice", 1002);
b.remove("bob", 1004);   // vence al add(1005)? no, 1005 > 1004
b.add("carol", 1015);

// Merge (convergente)
const m = a.merge(b);
console.log(m.values());         // ["bob","carol"]
console.log(m.has("alice"));     // false, remove(1010) > add(1002)
*/
