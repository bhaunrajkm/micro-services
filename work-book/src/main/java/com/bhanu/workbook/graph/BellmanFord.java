package com.bhanu.workbook.graph;

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        int v = 5;
        int[][] graph = {
                {0, -1, 4, 0, 0},
                {0, 0, 3, 2, 2},
                {0, 0, 0, 0, 0},
                {0, 1, 5, 0, 0},
                {0, 0, 0, -3, 0}};

        int source = 0;
        int[] dp = new int[v];
        for (int i = 0; i < v; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[source] = 0;

        for (int ve = 0; ve < v - 1; ve++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (graph[i][j] != 0 && (graph[i][j] + dp[i]) < dp[j]) {
                        dp[j] = graph[i][j] + dp[i];
                    }
                }
            }
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dp[i] != Integer.MAX_VALUE
                        && graph[i][j] != 0
                        && dp[i] + graph[i][j] < dp[j]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
