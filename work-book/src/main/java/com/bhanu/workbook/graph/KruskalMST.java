package com.bhanu.workbook.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class KruskalMST {
    public static void main(String[] args) {
        int v = 7;
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 28),
                new Edge(2, 3, 16),
                new Edge(3, 4, 12),
                new Edge(4, 5, 22),
                new Edge(5, 6, 25),
                new Edge(6, 1, 10),
                new Edge(5, 7, 24),
                new Edge(4, 7, 18),
                new Edge(2, 7, 14));

        Queue<Edge> minHeap = new PriorityQueue<Edge>(Comparator.comparingInt(Edge::getWeight));

        for (Edge e : edges) {
            minHeap.add(e);
        }

        int sum = 0;
        int i = 0;
        Set<Edge> visited = new HashSet<>();
        while (i < v - 1) {
            Edge e = minHeap.remove();
            if (!isCyclic(visited, e)) {
                visited.add(e);
                sum += e.getWeight();
                i++;
            }
        }

        System.out.println(sum);
    }

    private static boolean isCyclic(Set<Edge> edges,
                                    Edge e) {
        Set<Integer> vSet = new HashSet<>();
        vSet.add(e.getU());
        vSet.add(e.getV());
        for (Edge edge : edges) {
            vSet.add(edge.getU());
            vSet.add(edge.getV());
        }

        int[] v = new int[vSet.size()];
        int j = 0;
        for (int i : vSet) {
            v[j] = i;
            j++;
        }

        int[] visited = new int[vSet.size()];
        for (int i = 0; i < vSet.size(); i++) {
            if (visited[i] != 1) {
                if (isCyclicUtil(visited, v, i, -1, edges, e))
                    return true;
            }
        }
        return false;
    }

    /**
     * If you are visiting already visited node and it is not ur parent then there is a cycle
     */
    private static boolean isCyclicUtil(int[] visited, int[] v, int i, int parent, Set<Edge> edges, Edge e) {
        visited[i] = 1;
        for (int u = 0; u < visited.length; u++) {
            int finalU = u;
            if (edges.stream().anyMatch(x -> (v[i] == x.getU() && v[finalU] == x.getV()) || (v[i] == x.getV() && v[finalU] == x.getU())) ||
                    ((v[i] == e.getU() && v[u] == e.getV()) || (v[i] == e.getV() && v[u] == e.getU()))) {
                if (visited[u] != 1) {
                    if (isCyclicUtil(visited, v, u, v[i], edges, e))
                        return true;
                } else if (v[u] != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Edge {
        int v;
        int u;
        int weight;
    }
}
