// OPTIMIZED ALGO WELSH POWELL ALGO

/**
 * T.C: O(V^2)
 * 
 * 1. Step 1: Degree Counting & Initialization — O(V + E))
 * 2. Step 2: Sorting Vertices by Degree — O(Vlog V))
 * 3. Step 3, 4 & 5: Coloring Process — O(V^2))
 * 
 * S.C : O(V^2)
 * 
 */

import java.util.*;

class Graph {
    private int V; // Number of vertices
    private int[][] adjMatrix; // Adjacency Matrix for O(1) edge lookup
    private List<Integer>[] adjList; // Adjacency List to easily count degrees

    // Inner class to represent a vertex and its degree
    class Vertex implements Comparable<Vertex> {
        int id;
        int degree;

        Vertex(int id, int degree) {
            this.id = id;
            this.degree = degree;
        }

        // Overridden to sort vertices in descending order of their degrees
        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(other.degree, this.degree);
        }
    }


    public Graph(int v) {
        V = v;
        adjMatrix = new int[v][v];
        adjList = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        adjList[u].add(v);
        adjList[v].add(u);
    }

    // Executes the Welsh-Powell Algorithm step-by-step
    public void welshPowellColoring() {
        // Step 1: Find the degree of each vertex & build list
        List<Vertex> vertexList = new ArrayList<>();
        System.out.println("--- Step 1: Degrees of Vertices ---");
        for (int i = 0; i < V; i++) {
            int degree = adjList[i].size();
            vertexList.add(new Vertex(i, degree));
            System.out.println("Vertex " + i + " -> Degree: " + degree);
        }

        // Step 2: List the vertices in order of descending degrees
        Collections.sort(vertexList);

        // Array to store assigned colors (-1 means uncolored)
        int[] resultColors = new int[V];
        Arrays.fill(resultColors, -1);

        int currentColor = 1; // Start coloring with Color 1
        int coloredCount = 0;

        System.out.println("--- Step 3, 4 & 5: Coloring Process ---");
        
        // Loop until all vertices are colored
        while (coloredCount < V) {
            List<Integer> currentPassColored = new ArrayList<>();

            // Move down the sorted list
            for (int i = 0; i < V; i++) {
                Vertex currentVertex = vertexList.get(i);
                int u = currentVertex.id;

                // Check if this vertex is still uncolored
                if (resultColors[u] == -1) {
                    boolean canColor = true;

                    // Verify if it is connected to any vertex already colored with the CURRENT color
                    for (int alreadyColored : currentPassColored) {
                        if (adjMatrix[u][alreadyColored] == 1) {
                            canColor = false;
                            break;
                        }
                    }

                    // If not connected, assign the current color
                    if (canColor) {
                        resultColors[u] = currentColor;
                        currentPassColored.add(u);
                        coloredCount++;
                    }
                }
            }
            
            System.out.println("Color " + currentColor + " assigned to Vertices: " + currentPassColored);
            currentColor++; // Move to a new color for the next uncolored set
        }

        // Print final summary
        System.out.println("\n--- Final Vertex Coloring Summary ---");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " ---> Color " + resultColors[i]);
        }
    }

    public static void main(String[] args) {
        // Test Graph 1 (Same as your first greedy example graph)
        System.out.println("=========================================");
        System.out.println("            RUNNING GRAPH 1              ");
        System.out.println("=========================================");
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.welshPowellColoring();

        // Test Graph 2 (Same as your second greedy example graph)
        System.out.println("\n=========================================");
        System.out.println("            RUNNING GRAPH 2              ");
        System.out.println("=========================================");
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        g2.welshPowellColoring();
    }
}


// =================================================================================================================================

import java.util.*;

class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    // Constructor
    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Graph is undirected
    }

    // Assigns colors (starting from 0) to all vertices and prints the assignment
    void greedyColoring() {
        int result[] = new int[V];

        // Initialize all vertices as unassigned (-1)
        Arrays.fill(result, -1);

        // Assign the first color to the first vertex
        result[0] = 0;

        // A temporary array to store the available colors. 
        // True value of available[cr] means that the color 'cr' is assigned to one of its adjacent vertices
        boolean available[] = new boolean[V];
        Arrays.fill(available, true);

        // Assign colors to remaining V-1 vertices
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors as unavailable
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }

            // Find the first available color
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr]) {
                    break;
                }
            }

            result[u] = cr; // Assign the found color

            // Reset the values back to true for the next iteration
            Arrays.fill(available, true);
        }

        // Print the result
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + " ---> Color " + result[u]);
        }
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1:");
        g1.greedyColoring();
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2:");
        g2.greedyColoring();
    }
}


