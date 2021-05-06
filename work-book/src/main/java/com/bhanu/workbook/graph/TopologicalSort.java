package com.bhanu.workbook.graph;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        int v = 6;
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(2, 3),
                Arrays.asList(3, 1),
                Arrays.asList(5, 2),
                Arrays.asList(5, 0),
                Arrays.asList(4, 0),
                Arrays.asList(4, 1));

        int[] inDegree = new int[v];
        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)] += 1;
        }
        List<Integer> order = new ArrayList<>();
        topologicalSort(v, inDegree, edges, order);
        int i = 0;
        for (; i < v; i++) {
            if (inDegree[i] != 0) {
                break;
            }
        }

        if (i == v) {
            System.out.println(order);
        } else {
            System.out.println("Not possible");
        }
    }

    private static void topologicalSort(int v, int[] inDegree, List<List<Integer>> edges, List<Integer> order) {
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0 && !order.contains(i)) {
                order.add(i);
                for (List<Integer> edge : edges) {
                    if (edge.get(0) == i) {
                        inDegree[edge.get(1)] = inDegree[edge.get(1)] - 1;
                    }
                }
                topologicalSort(v, inDegree, edges, order);
            }
        }
    }

}
