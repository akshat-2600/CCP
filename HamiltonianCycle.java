// T.C : O(V!)
// S.C : O(V^2)

import java.util.Arrays;
import java.util.Scanner;

public class HamiltonianCycle {
    // Static variables belong to the class rather than an object instance
    private static int V, pathCount;
    private static int[] path;
    private static int[][] graph;

    public static void findHamiltonianCycle(int[][] g) {
        V = g.length;
        path = new int[V];
        Arrays.fill(path, -1);
        graph = g;
        
        try {
            path[0] = 0;
            pathCount = 1;
            solve(0);
            System.out.println("No solution");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            display();
        }
    }

    public static void solve(int vertex) throws Exception {
        // Base case: If all vertices are included and there is an edge back to the start (vertex 0)
        if (graph[vertex][0] == 1 && pathCount == V) {
            throw new Exception("Solution found");
        }
        
        // If all vertices are visited but no cycle back to the start exists
        if (pathCount == V) {
            return;
        }

        for (int v = 0; v < V; v++) {
            if (graph[vertex][v] == 1) {
                path[pathCount++] = v;
                
                // Temporarily remove the edge (Backtracking step)
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
                
                if (!isPresent(v)) {
                    solve(v);
                }
                
                // Restore the edge (Backtracking step)
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                path[--pathCount] = -1;
            }
        }
    }

    public static boolean isPresent(int v) {
        for (int i = 0; i < pathCount - 1; i++) {
            if (path[i] == v) {
                return true;
            }
        }
        return false;
    }

    public static void display() {
        System.out.print("\nPath : ");
        for (int i = 0; i <= V; i++) {
            System.out.print(path[i % V] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int V = scan.nextInt();
        int[][] inputGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                inputGraph[i][j] = scan.nextInt();
            }
        }
        
        findHamiltonianCycle(inputGraph);
        
        scan.close();
    }
}
