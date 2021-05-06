package com.bhanu.workbook.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=Z_yuwfriWAw
 * T.C: O(V+E logV)
 */
public class Dijkstra {
    public static void main(String[] args) {
        int v = 4;
        int[][] graph = {
                {0, 2, 2, 0},
                {2, 0, 1, 3},
                {2, 1, 0, 2},
                {0, 3, 2, 0}};

        int[] distance = new int[v];
        int[] parent = new int[v];

        for (int i = 0; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        distance[0] = 0;

        Set<Integer> visited = new HashSet<>();

        for (int times = 0; times < v - 1; times++) {
            int u = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < v; i++) {
                if (!visited.contains(i) && distance[i] < min) {
                    min = distance[i];
                    u = i;
                }
            }
            visited.add(u);

            for (int i = 0; i < v; i++) {
                if (graph[u][i] != 0 && graph[u][i] + distance[u] < distance[i]) {
                    distance[i] = graph[u][i] + distance[u];
                    parent[i] = u;
                }
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.println(parent[i]);
        }
    }
}
