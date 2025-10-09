import java.util.*;

public class DijkstraShortestPath {
    // Edge structure representing a graph connection and its weight
    static class Edge {
        int target, weight;
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    /**
     * Dijkstra's Algorithm: Finds the shortest distances from the source node to all other nodes in a weighted graph.
     * - Uses a priority queue to always expand the node with the smallest tentative distance next.
     * - Updates distances for neighboring nodes whenever a shorter path is found.
     * - Returns an array of shortest distances from the source.
     */
    public static int[] dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;

            // For each neighbor, update the distance if a shorter path is found
            for (Edge e : graph.get(u)) {
                if (dist[e.target] > dist[u] + e.weight) {
                    dist[e.target] = dist[u] + e.weight;
                    pq.offer(new int[]{e.target, dist[e.target]});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Example graph: 5 nodes, various weighted edges
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        graph.get(0).add(new Edge(1, 10));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 2));
        graph.get(2).add(new Edge(1, 4));
        graph.get(2).add(new Edge(3, 8));
        graph.get(2).add(new Edge(4, 2));
        graph.get(3).add(new Edge(4, 7));
        graph.get(4).add(new Edge(3, 9));

        // Calculate shortest paths from node 0
        int[] dist = dijkstra(graph, 0);
        System.out.println("Distance from node 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("to " + i + " = " + dist[i]);
        }
    }
}
