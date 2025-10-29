// Bloom Filter sin dependencias externas
export class BloomFilter {
  constructor({ mBits, kHashes }) {
    if (!Number.isInteger(mBits) || mBits <= 0) throw new Error("mBits inválido");
    if (!Number.isInteger(kHashes) || kHashes <= 0) throw new Error("kHashes inválido");
    this.m = mBits;
    this.k = kHashes;
    this.bits = new Uint8Array(Math.ceil(mBits / 8));
    this.n = 0; // elementos añadidos (aprox)
  }

  static optimal({ nItems, falsePositiveRate = 0.01 }) {
    // m ≈ -(n ln p) / (ln 2)^2 ; k ≈ (m/n) ln 2
    const ln2 = Math.log(2);
    const m = Math.ceil(-(nItems * Math.log(falsePositiveRate)) / (ln2 * ln2));
    const k = Math.max(1, Math.round((m / Math.max(1, nItems)) * ln2));
    return new BloomFilter({ mBits: m, kHashes: k });
  }

  add(value) {
    const [h1, h2] = this.#hashPair(value);
    for (let i = 0; i < this.k; i++) {
      const idx = (h1 + i * h2) % this.m;
      this.#setBit(idx);
    }
    this.n++;
  }

  has(value) {
    const [h1, h2] = this.#hashPair(value);
    for (let i = 0; i < this.k; i++) {
      const idx = (h1 + i * h2) % this.m;
      if (!this.#getBit(idx)) return false;
    }
    return true; // quizá falso positivo, pero nunca falso negativo
  }

  estimateFalsePositiveRate() {
    // p ≈ (1 - e^{-kn/m})^k
    const p = Math.pow(1 - Math.exp(-(this.k * this.n) / this.m), this.k);
    return p;
  }

  toJSON() {
    return {
      m: this.m,
      k: this.k,
      n: this.n,
      bits: Buffer.from(this.bits).toString("base64"),
    };
  }
  static fromJSON(obj) {
    const bf = new BloomFilter({ mBits: obj.m, kHashes: obj.k });
    bf.n = obj.n;
    bf.bits = new Uint8Array(Buffer.from(obj.bits, "base64"));
    return bf;
  }

  #setBit(i) {
    const byte = i >> 3, bit = i & 7;
    this.bits[byte] |= (1 << bit);
  }
  #getBit(i) {
    const byte = i >> 3, bit = i & 7;
    return (this.bits[byte] & (1 << bit)) !== 0;
  }

  // FNV-1a 32-bit
  #fnv1a(str, seed = 0x811c9dc5) {
    let hash = seed >>> 0;
    for (let i = 0; i < str.length; i++) {
      hash ^= str.charCodeAt(i);
      hash = Math.imul(hash, 0x01000193); // 16777619
    }
    return hash >>> 0;
  }
  #hashPair(value) {
    const s = typeof value === "string" ? value : JSON.stringify(value);
    // double hashing: h_i = h1 + i*h2
    const h1 = this.#fnv1a(s, 0x811c9dc5) % this.m;
    const h2 = (this.#fnv1a(s, 0x01000193) % (this.m - 1)) + 1; // evitar 0
    return [h1, h2];
  }
}

/* Ejemplo:
const bf = BloomFilter.optimal({ nItems: 10000, falsePositiveRate: 0.01 });
bf.add("alice"); bf.add("bob");
console.log(bf.has("alice")); // true
console.log(bf.has("mallory")); // quizá true (fp), lo normal false
console.log(bf.estimateFalsePositiveRate());
*/
