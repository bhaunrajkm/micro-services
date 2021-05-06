package com.bhanu.workbook.graph;

import java.util.Arrays;

public class TSP {
    public static void main(String[] args) {
        int v = 4;
        int[] visited = new int[v];
        int[][] graph = {
                {0, 20, 42, 25},
                {20, 0, 30, 34},
                {42, 30, 0, 10},
                {25, 34, 10, 0}};

        int[][] dp = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(tsp(dp, visited, graph, v, 0, -1));
    }

    /**
     * T.C: O(2^n * n)
     * visited -> 2^n
     * pos -> n times
     *
     * @param visited
     * @param graph
     * @param v
     * @param pos
     * @return
     */
    private static int tsp(int[][] dp,
                           int[] visited,
                           int[][] graph,
                           int v,
                           int pos,
                           int parent) {
        if (Arrays.stream(visited).allMatch(x -> x == 1)) {
            return graph[pos][0];
        }
        if (parent != -1 && dp[parent][pos] != -1) {
            return dp[parent][pos];
        }

        int min = Integer.MAX_VALUE;

        for (int u = 0; u < v; u++) {
            if (visited[u] == 0) {
                visited[u] = 1;
                int newMin = graph[pos][u] + tsp(dp, visited, graph, v, u, pos);
                min = Math.min(min, newMin);
            }
        }

        if (parent != -1) {
            dp[parent][pos] = min;
        }
        return min;
    }
}
