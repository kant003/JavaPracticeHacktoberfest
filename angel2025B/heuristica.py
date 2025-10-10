import heapq

def astar(grid, start, goal):
    """
    grid: lista de strings o matriz de 0/1 (1 = obstáculo)
    start, goal: (r, c)
    """
    R, C = len(grid), len(grid[0])
    def walkable(r, c):
        return 0 <= r < R and 0 <= c < C and (grid[r][c] in (0, '.') if isinstance(grid[r][c], int)==False else grid[r][c]==0)
    def h(a, b):  # Manhattan
        return abs(a[0]-b[0]) + abs(a[1]-b[1])

    g = {start: 0}
    parent = {start: None}
    pq = [(h(start, goal), 0, start)]  # (f, g, pos)
    visited = set()

    while pq:
        f, gcost, u = heapq.heappop(pq)
        if u in visited: 
            continue
        visited.add(u)
        if u == goal:
            # reconstruir
            path = []
            cur = u
            while cur:
                path.append(cur)
                cur = parent[cur]
            return path[::-1]
        r, c = u
        for dr, dc in ((1,0),(-1,0),(0,1),(0,-1)):
            nr, nc = r+dr, c+dc
            v = (nr, nc)
            if walkable(nr, nc):
                ng = gcost + 1
                if v not in g or ng < g[v]:
                    g[v] = ng
                    parent[v] = u
                    heapq.heappush(pq, (ng + h(v, goal), ng, v))
    return None

# Ejemplo:
grid = [
    [0,0,0,1,0],
    [1,1,0,1,0],
    [0,0,0,0,0],
    [0,1,1,1,0],
    [0,0,0,0,0],
]
path = astar(grid, (0,0), (4,4))
path
