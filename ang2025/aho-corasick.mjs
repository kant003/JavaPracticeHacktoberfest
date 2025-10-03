// Autómata Aho–Corasick para múltiples patrones (ASCII/UTF-16 simple)
export class AhoCorasick {
  constructor(patterns = []) {
    this.next = [];          // trie: array de Map<char, state>
    this.fail = [];          // fall links
    this.out = [];           // out[state] = array de ids de patrón que terminan aquí
    this.patterns = patterns;
    this.#build(patterns);
  }

  #newState() {
    this.next.push(new Map());
    this.fail.push(0);
    this.out.push([]);
    return this.next.length - 1;
  }

  #build(patterns) {
    this.next = []; this.fail = []; this.out = [];
    const root = this.#newState();

    // 1) construir trie
    patterns.forEach((pat, id) => {
      let s = root;
      for (const ch of pat) {
        if (!this.next[s].has(ch)) this.next[s].set(ch, this.#newState());
        s = this.next[s].get(ch);
      }
      this.out[s].push(id);
    });

    // 2) construir fall links (BFS)
    const q = [];
    for (const [ch, s] of this.next[root]) {
      this.fail[s] = root;
      q.push(s);
    }
    while (q.length) {
      const r = q.shift();
      for (const [ch, s] of this.next[r]) {
        q.push(s);
        let f = this.fail[r];
        while (f && !this.next[f].has(ch)) f = this.fail[f];
        this.fail[s] = this.next[f].get(ch) ?? root;
        // unir salidas
        this.out[s].push(...this.out[this.fail[s]]);
      }
    }
  }

  /**
   * Escanea texto y devuelve coincidencias: { patternId, endIndex }[]
   * O(n + z) donde z = nº de matches
   */
  findAll(text) {
    const res = [];
    let s = 0;
    for (let i = 0; i < text.length; i++) {
      const ch = text[i];
      while (s && !this.next[s].has(ch)) s = this.fail[s];
      s = this.next[s].get(ch) ?? 0;
      if (this.out[s].length) {
        for (const id of this.out[s]) {
          res.push({ patternId: id, endIndex: i });
        }
      }
    }
    return res;
  }
}

/* Ejemplo:
const ac = new AhoCorasick(["lorem", "ipsum", "dolor"]);
const text = "loremXipsumYdolor lorem";
console.log(ac.findAll(text).map(m => ({pat: ac.patterns[m.patternId], end: m.endIndex})));
*/
