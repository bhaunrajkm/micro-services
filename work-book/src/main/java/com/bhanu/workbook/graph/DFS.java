package com.bhanu.workbook.graph;

public class DFS {
    public static void main(String[] args) {
        int g[][] = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        //O(V + E)

        int visited[] = new int[g.length];
        dfs(0, visited, g);
    }

    private static void dfs(int v, int[] visited, int g[][]) {
        System.out.println(v);
        visited[v] = 1;
        for (int i = 0; i < visited.length; i++) {
            if (g[v][i] == 1 && visited[i] == 0) {
                dfs(i, visited, g);
            }
        }
    }
}
