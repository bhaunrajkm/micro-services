package com.bhanu.workbook.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubset {

  public static void main(String[] args) {
    List<Integer> set = Arrays.asList(1, 2, 3);
    List<List<Integer>> result = new ArrayList<>();
    generateSubs(set, 0, new ArrayList<Integer>(), result);
    System.out.println(result.size());
  }

  private static void generateSubs(List<Integer> set,
                                   int index,
                                   ArrayList<Integer> current,
                                   List<List<Integer>> result) {
    result.add(new ArrayList<>(current));

    for (int i = index; i < set.size(); i++) {
      System.out.println("i=" + i);
      current.add(set.get(i));
      generateSubs(set, i + 1, current, result);
      current.remove(current.size() - 1);
    }
  }
}
/*
  123 -> 1, 2, 3,
 */