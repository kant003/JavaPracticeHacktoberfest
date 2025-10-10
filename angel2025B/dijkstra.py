import heapq
from math import inf

def dijkstra(graph, src):
    """
    graph: dict[u] = list[(v, w)]
    src:   nodo origen
    return dist, parent
    """
    dist = {u: inf for u in graph}
    parent = {u: None for u in graph}
    dist[src] = 0
    pq = [(0, src)]
    while pq:
        d, u = heapq.heappop(pq)
        if d != dist[u]:
            continue
        for v, w in graph[u]:
            nd = d + w
            if nd < dist[v]:
                dist[v] = nd
                parent[v] = u
                heapq.heappush(pq, (nd, v))
    return dist, parent

# Ejemplo:
g = {
    'A': [('B', 2), ('C', 5)],
    'B': [('C', 1), ('D', 4)],
    'C': [('D', 1)],
    'D': []
}
dist, parent = dijkstra(g, 'A')
# Camino A->D:
camino = []
u = 'D'
while u is not None:
    camino.append(u)
    u = parent[u]
camino[::-1], dist['D']
