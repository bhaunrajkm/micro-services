package com.bhanu.workbook.genericJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleDArray2TwoDArray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> quires = new ArrayList<>();
        quires.add(Arrays.asList(1, 1));
        quires.add(Arrays.asList(1, 2));
        quires.add(Arrays.asList(2, 1));
        quires.add(Arrays.asList(2, 2));

        System.out.println(getElements(arr, quires));
    }

    private static List<Integer> getElements(List<Integer> a,
                                             List<List<Integer>> quires) {
        int length = a.get(0);
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : quires) {
            result.add(a.get((length * (list.get(0) - 1)) + list.get(1)));
        }
        return result;
    }
}
