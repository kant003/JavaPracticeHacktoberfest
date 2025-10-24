class DSU:
    def __init__(self, n):
        self.p = list(range(n))
        self.r = [0]*n
    def find(self, x):
        if self.p[x] != x:
            self.p[x] = self.find(self.p[x])
        return self.p[x]
    def union(self, a, b):
        a, b = self.find(a), self.find(b)
        if a == b: 
            return False
        if self.r[a] < self.r[b]:
            a, b = b, a
        self.p[b] = a
        if self.r[a] == self.r[b]:
            self.r[a] += 1
        return True

def kruskal(n, edges):
    """
    n: número de nodos [0..n-1]
    edges: lista (w,u,v)
    return (peso_total, aristas_del_mst)
    """
    dsu = DSU(n)
    mst = []
    total = 0
    for w,u,v in sorted(edges):
        if dsu.union(u,v):
            mst.append((u,v,w))
            total += w
            if len(mst) == n-1:
                break
    return total, mst

# Ejemplo:
n = 5
edges = [
    (1,0,1),(3,0,2),(4,1,2),(2,1,3),
    (5,2,3),(7,2,4),(6,3,4)
]
kruskal(n, edges)
