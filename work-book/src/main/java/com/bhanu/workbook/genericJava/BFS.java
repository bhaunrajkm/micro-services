package com.bhanu.workbook.genericJava;

import java.util.ArrayDeque;
import java.util.Queue;

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
