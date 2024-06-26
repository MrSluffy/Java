/*
Refer https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
for better understanding
 */
package com.thealgorithms.datastructures.graphs;

class Dijkstras {

    int k = 9;

    int minDist(int[] dist, Boolean[] set) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int r = 0; r < k; r++) {
            if (!set[r] && dist[r] <= min) {
                min = dist[r];
                minIndex = r;
            }
        }

        return minIndex;
    }

    void print(int[] dist) {
        System.out.println("Vertex \t\t Distance");
        for (int i = 0; i < k; i++) {
            System.out.println(i + " \t " + dist[i]);
        }
    }

    void dijkstra(int[][] graph, int src) {
        int[] dist = new int[k];
        Boolean[] set = new Boolean[k];

        for (int i = 0; i < k; i++) {
            dist[i] = Integer.MAX_VALUE;
            set[i] = Boolean.FALSE;
        }

        dist[src] = 0;

        for (int c = 0; c < k - 1; c++) {
            int u = minDist(dist, set);

            set[u] = Boolean.TRUE;

            for (int v = 0; v < k; v++) {
                if (!set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        print(dist);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0},
        };
        Dijkstras t = new Dijkstras();
        t.dijkstra(graph, 0);
    } // main
} // djikstras
/*
OUTPUT :
Vertex   Distance
0            0
1            4
2            12
3            19
4            21
5            11
6            9
7            8
8            14
 */
