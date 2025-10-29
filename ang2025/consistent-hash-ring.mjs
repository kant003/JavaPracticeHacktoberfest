// Consistent Hash Ring con virtual nodes (sin deps)
export class ConsistentHashRing {
  constructor({ replicas = 100 } = {}) {
    this.replicas = replicas;
    this.ring = new Map();     // hash -> nodeId
    this.sorted = [];          // hashes ordenados
    this.nodes = new Set();    // nodeId reales
  }

  addNode(nodeId) {
    if (this.nodes.has(nodeId)) return;
    this.nodes.add(nodeId);
    for (let i = 0; i < this.replicas; i++) {
      const key = `${nodeId}#${i}`;
      const h = this.#hash32(key);
      this.ring.set(h, nodeId);
      this.sorted.push(h);
    }
    this.sorted.sort((a, b) => (a - b));
  }

  removeNode(nodeId) {
    if (!this.nodes.has(nodeId)) return;
    this.nodes.delete(nodeId);
    this.sorted = this.sorted.filter(h => {
      if (this.ring.get(h) === nodeId) {
        this.ring.delete(h);
        return false;
      }
      return true;
    });
  }

  getNode(key) {
    if (this.sorted.length === 0) return null;
    const h = this.#hash32(String(key));
    // binary search del primer hash >= h
    let l = 0, r = this.sorted.length - 1, ans = -1;
    while (l <= r) {
      const m = (l + r) >> 1;
      if (this.sorted[m] >= h) { ans = m; r = m - 1; }
      else l = m + 1;
    }
    const idx = ans === -1 ? 0 : ans;
    const point = this.sorted[idx];
    return this.ring.get(point);
  }

  // FNV-1a 32-bit simple (coherente con el Bloom)
  #hash32(s, seed = 0x811c9dc5) {
    let h = seed >>> 0;
    for (let i = 0; i < s.length; i++) {
      h ^= s.charCodeAt(i);
      h = Math.imul(h, 0x01000193);
    }
    return h >>> 0;
  }
}

/* Ejemplo:
const ring = new ConsistentHashRing({ replicas: 200 });
ring.addNode("cache-A");
ring.addNode("cache-B");
ring.addNode("cache-C");

console.log(ring.getNode("user:42"));
console.log(ring.getNode("user:99"));

ring.removeNode("cache-B"); // reubica mínimamente
console.log(ring.getNode("user:42"));
*/
