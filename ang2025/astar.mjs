import { PriorityQueue } from "./priority-queue.mjs";

/**
 * neighborsFn(u) -> array de { v, cost }
 * heuristic(u, goal) -> estimación admisible (≥0)
 * Devuelve: { path, cost, visited }
 */
export function aStar(start, goal, { neighborsFn, heuristic }) {
  const open = new PriorityQueue((a, b) => a.f - b.f);
  const cameFrom = new Map();
  const gScore = new Map([[start, 0]]);
  const fScore = new Map([[start, heuristic(start, goal)]]);
  const inOpen = new Set([start]);

  open.push({ node: start, f: fScore.get(start) });

  const visited = new Set();

  while (open.size()) {
    const { node } = open.pop();
    inOpen.delete(node);
    if (node === goal) {
      const path = reconstruct(cameFrom, node);
      return { path, cost: gScore.get(node), visited };
    }
    visited.add(node);

    for (const { v, cost } of neighborsFn(node)) {
      const tentative = gScore.get(node) + cost;
      if (tentative < (gScore.get(v) ?? Infinity)) {
        cameFrom.set(v, node);
        gScore.set(v, tentative);
        const f = tentative + heuristic(v, goal);
        fScore.set(v, f);
        if (!inOpen.has(v)) {
          open.push({ node: v, f });
          inOpen.add(v);
        }
      }
    }
  }
  return { path: [], cost: Infinity, visited };
}

function reconstruct(cameFrom, current) {
  const path = [current];
  while (cameFrom.has(current)) {
    current = cameFrom.get(current);
    path.push(current);
  }
  return path.reverse();
}

/* Ejemplo en grid 2D con 4-neighbors (Manhattan) */
export function gridNeighbors(width, height, walls = new Set()) {
  return (i) => {
    const res = [];
    const x = i % width, y = (i / width) | 0;
    const push = (nx, ny) => {
      if (nx < 0 || ny < 0 || nx >= width || ny >= height) return;
      const ni = ny * width + nx;
      if (!walls.has(ni)) res.push({ v: ni, cost: 1 });
    };
    push(x + 1, y); push(x - 1, y); push(x, y + 1); push(x, y - 1);
    return res;
  };
}
export const manhattan = (width) => (a, b) => {
  const ax = a % width, ay = (a / width) | 0;
  const bx = b % width, by = (b / width) | 0;
  return Math.abs(ax - bx) + Math.abs(ay - by);
};
