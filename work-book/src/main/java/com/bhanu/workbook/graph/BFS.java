package com.bhanu.workbook.graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * BFS
 * DFS
 * Topological Sort & Shortest-path in a DAG
 * Dijkstra's algorithm
 * Bellman-Ford
 * A-star (A*)
 * Floyd-Warshall (debatable, but it's 5 lines of code, so no reason not to know it)
 *
 * Breadth-first search - done
 * Depth-first search - done
 * Topological sorting - done
 * Bellman-Ford algorithm
 * Dijkstra’s algorithm
 * Minimum spanning trees
 * Floyd-Warshall algorithm
 * Johnson's algorithm
 * Maximum bipartite matching
 * A* search algorithm
 */
public class BFS {
    public static void main(String[] args) {
        int[][] g = {{0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}};
        //T.C = O(V+E)

        int[] visited = new int[g.length];
        Queue<Integer> q = new ArrayDeque<>();
        visited[0] = 1;
        q.add(0);

        while (!q.isEmpty()) {
            int de = q.remove();
            System.out.println(de);

            for (int i = 0; i < g.length; i++) {
                if (visited[i] == 0 && g[de][i] == 1) {
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}
