export class PriorityQueue {
  constructor(compare = (a, b) => a.priority - b.priority) {
    this._heap = [];
    this._compare = compare;
  }
  size() { return this._heap.length; }
  _swap(i, j) { [this._heap[i], this._heap[j]] = [this._heap[j], this._heap[i]]; }
  _parent(i) { return ((i - 1) >> 1); }
  _left(i) { return (i << 1) + 1; }
  _right(i) { return (i << 1) + 2; }

  push(value) {
    this._heap.push(value);
    this._siftUp();
  }
  pop() {
    if (this.size() === 0) return undefined;
    const top = this._heap[0];
    const end = this._heap.pop();
    if (this.size() > 0) {
      this._heap[0] = end;
      this._siftDown();
    }
    return top;
  }
  _siftUp() {
    let i = this.size() - 1;
    while (i > 0) {
      const p = this._parent(i);
      if (this._compare(this._heap[i], this._heap[p]) < 0) {
        this._swap(i, p); i = p;
      } else break;
    }
  }
  _siftDown() {
    let i = 0;
    while (true) {
      const l = this._left(i), r = this._right(i);
      let m = i;
      if (l < this.size() && this._compare(this._heap[l], this._heap[m]) < 0) m = l;
      if (r < this.size() && this._compare(this._heap[r], this._heap[m]) < 0) m = r;
      if (m !== i) { this._swap(i, m); i = m; } else break;
    }
  }
}
