import java.util.*;

public class DijkstraAlgorithm {

    // Representation of a graph edge / neighbor node
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            class Pair implements Comparable<Pair> {
                int node;
                int distance;

                Pair(int node, int distance) {
                    this.node = node;
                    this.distance = distance;
                }

        // Compare based on distance to ensure the Priority Queue acts as a Min-Heap
        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int vertices, List<List<Edge>> adj, int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Min-Heap to greedily pick the node with the absolute smallest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.distance;

            // Optimization: Skip processing if we already found a shorter path to u
            if (d > dist[u]) continue;

            // Explore all neighbors of u
            for (Edge edge : adj.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Constructing a directed graph
        adj.get(0).add(new Edge(1, 9));
        adj.get(0).add(new Edge(2, 6));
        adj.get(0).add(new Edge(3, 5));
        adj.get(0).add(new Edge(4, 3));

        adj.get(2).add(new Edge(1, 2));
        adj.get(2).add(new Edge(3, 4));

        int source = 0;
        int[] distances = dijkstra(vertices, adj, source);

        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To node " + i + " -> " + (distances[i] == Integer.MAX_VALUE ? "Unreachable" : distances[i]));
        }
    }
}
