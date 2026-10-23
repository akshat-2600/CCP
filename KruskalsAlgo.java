// T.C : O(ElogE)
// S.C : O(V + E)

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dst, wt;
    
    Edge(int s, int d, int w) {
        src = s;
        dst = d;
        wt  = w;
    }

    // FIX 1: Must implement compareTo for Collections.sort() to work
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.wt, other.wt);
    }
}

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank   = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    void UNION(int x, int y) {
        int parent_x = find(x); 
        int parent_y = find(y);

        if (parent_x == parent_y) return; 

        // Union by rank
        if (rank[parent_x] < rank[parent_y]) {
            parent[parent_x] = parent_y;
        } else if (rank[parent_x] > rank[parent_y]) {
            parent[parent_y] = parent_x;
        } else {
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
}

class KruskalsAlgo {
    
    static void run(int n, List<Edge> edges) {
        Collections.sort(edges);
        DSU uf = new DSU(n);
        List<Edge> mst = new ArrayList<>();
        int total = 0;

        for (Edge e : edges) {
            if (uf.find(e.src) != uf.find(e.dst)) {
                uf.UNION(e.src, e.dst);
                mst.add(e);
                total += e.wt;
            }
        }

        for (Edge e : mst) {
            System.out.println(e.src + "-" + e.dst + ":" + e.wt);
        }
        System.out.println("Total weight: " + total);
    }

    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 4));
        edges.add(new Edge(0, 2, 3));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 3, 4));
        KruskalsAlgo.run(4, edges);
    }
}


//==================================================================================


