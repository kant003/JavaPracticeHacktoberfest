// HyperLogLog sencillo (m = 2^p registers). Requiere Node 10+ (BigInt).
export class HyperLogLog {
  /**
   * @param {number} p - precisión (4..18). m = 2^p registros.
   */
  constructor(p = 14) {
    if (p < 4 || p > 18) throw new Error("p fuera de rango (4..18)");
    this.p = p;
    this.m = 1 << p;
    this.reg = new Uint8Array(this.m);
    this.alpha = this.#alphaMM();
  }

  add(value) {
    const x = this.#hash64(value); // BigInt
    const idx = Number(x >> BigInt(64 - this.p));              // primeros p bits
    const w = Number((x << BigInt(this.p)) & ((BigInt(1) << BigInt(64)) - BigInt(1))); // resto
    const rho = 1 + this.#clz64(w);                            // posición primer 1
    if (rho > this.reg[idx]) this.reg[idx] = rho;
  }

  count() {
    // Estimador HLL
    let Zinv = 0.0, zeros = 0;
    for (let i = 0; i < this.m; i++) {
      Zinv += Math.pow(2, -this.reg[i]);
      if (this.reg[i] === 0) zeros++;
    }
    const E = this.alpha / Zinv; // estimación básica

    // Ajustes clásicos
    if (E <= (5 / 2) * this.m) {            // corrección lineal para rangos pequeños
      return zeros ? this.m * Math.log(this.m / zeros) : E;
    }
    if (E > (1 / 30) * Math.pow(2, 32)) {   // corrección para valores muy grandes
      return -Math.pow(2, 32) * Math.log(1 - E / Math.pow(2, 32));
    }
    return E;
  }

  merge(other) {
    if (this.p !== other.p) throw new Error("p incompatible");
    for (let i = 0; i < this.m; i++) this.reg[i] = Math.max(this.reg[i], other.reg[i]);
  }

  toJSON() {
    return { p: this.p, reg: Buffer.from(this.reg).toString("base64") };
  }
  static fromJSON(obj) {
    const h = new HyperLogLog(obj.p);
    h.reg = new Uint8Array(Buffer.from(obj.reg, "base64"));
    return h;
  }

  #alphaMM() {
    // alfa_m * m^2
    const m = this.m;
    let alpha;
    switch (m) {
      case 16: alpha = 0.673; break;
      case 32: alpha = 0.697; break;
      case 64: alpha = 0.709; break;
      default: alpha = 0.7213 / (1 + 1.079 / m);
    }
    return alpha * m * m;
  }

  // Conteo de ceros a la izquierda en 64 bits
  #clz64(x) {
    if (x === 0) return 64; // convención
    let n = 1;
    if ((x >> 32n) === 0n) { n += 32; x <<= 32n; }
    if ((x >> 48n) === 0n) { n += 16; x <<= 16n; }
    if ((x >> 56n) === 0n) { n += 8;  x <<= 8n; }
    if ((x >> 60n) === 0n) { n += 4;  x <<= 4n; }
    if ((x >> 62n) === 0n) { n += 2;  x <<= 2n; }
    n -= Number(x >> 63n);
    return n;
  }

  // Hash 64-bit simple (xorshift* sobre FNV-1a como seed)
  #hash64(value) {
    const s = typeof value === "string" ? value : JSON.stringify(value);
    let h = 0x811c9dc5 >>> 0;
    for (let i = 0; i < s.length; i++) {
      h ^= s.charCodeAt(i);
      h = Math.imul(h, 0x01000193);
    }
    let x = BigInt(h) | (BigInt(0x9e3779b97f4a7c15) << 1n); // mezclar seed
    // xorshift*
    x ^= x >> 12n; x ^= x << 25n; x ^= x >> 27n;
    x *= 0x2545F4914F6CDD1Dn;
    return x & ((1n << 64n) - 1n);
  }
}

/* Ejemplo:
const h1 = new HyperLogLog(14); // ~16k registers
for (let i = 0; i < 1_000_00; i++) h1.add(`user_${i}`);
console.log("Estimación:", Math.round(h1.count()));

const h2 = new HyperLogLog(14);
h2.add("extra");
h1.merge(h2);  // combinar streams
*/
