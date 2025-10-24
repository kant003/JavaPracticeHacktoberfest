class LazySegTree:
    def __init__(self, arr):
        self.n = len(arr)
        self.size = 1
        while self.size < self.n:
            self.size <<= 1
        self.seg = [0]*(2*self.size)
        self.lazy = [0]*(2*self.size)
        # build
        for i,v in enumerate(arr):
            self.seg[self.size+i] = v
        for i in range(self.size-1, 0, -1):
            self.seg[i] = self.seg[i<<1] + self.seg[i<<1|1]

    def _apply(self, idx, val, length):
        self.seg[idx] += val*length
        self.lazy[idx] += val

    def _push(self, idx, length):
        if self.lazy[idx] != 0:
            self._apply(idx<<1, self.lazy[idx], length//2)
            self._apply(idx<<1|1, self.lazy[idx], length//2)
            self.lazy[idx] = 0

    def _update(self, idx, l, r, ql, qr, val):
        if ql > r or qr < l:
            return
        if ql <= l and r <= qr:
            self._apply(idx, val, r-l+1)
            return
        self._push(idx, r-l+1)
        m = (l+r)//2
        self._update(idx<<1, l, m, ql, qr, val)
        self._update(idx<<1|1, m+1, r, ql, qr, val)
        self.seg[idx] = self.seg[idx<<1] + self.seg[idx<<1|1]

    def update(self, l, r, val):
        self._update(1, 0, self.size-1, l, r, val)

    def _query(self, idx, l, r, ql, qr):
        if ql > r or qr < l:
            return 0
        if ql <= l and r <= qr:
            return self.seg[idx]
        self._push(idx, r-l+1)
        m = (l+r)//2
        return self._query(idx<<1, l, m, ql, qr) + self._query(idx<<1|1, m+1, r, ql, qr)

    def query(self, l, r):
        return self._query(1, 0, self.size-1, l, r)

# Ejemplo:
arr = [1,2,3,4,5]
st = LazySegTree(arr)
st.update(1,3,10)   # +10 en [1,3]
st.query(0,4)       # suma total
st.query(2,4)       # suma parcial
