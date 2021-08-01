package com.bhanu.workbook.optionalexercise;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalSamples {

  public static void main(String[] args) {
//    Optional<Object> empty = Optional.empty();
//    if (!empty.isPresent()) {
//      System.out.println("not present");

//    Optional<String> str = Optional.of("bhanu");
//    System.out.println(str.get());

//    String s = "bhanu";
//    List<Integer> list = Arrays.asList(1, 2, 7, 88, 0);
//    List<Integer> integers = mulBy10(list);
//    System.out.println(integers);

    //[[1,2],[3,4],[5,6,7]]
//[1,2,3,4,5,6,7]
    List<List<Integer>> list = Arrays
        .asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6, 7));

    List<Integer> singleList = list.stream()
        .flatMap(outlistSingleElement -> outlistSingleElement.stream())
        .map(x -> x * 10)
        .collect(Collectors.toList());
    System.out.println(singleList);
  }

  static Optional<String> appendRaj(String s) {
//    if (StringUtils.isEmpty(s)) {
//      return Optional.of("raj");
//    }
//
//    return Optional.of(s + "raj");

    return Optional.ofNullable(s)
        .map(str -> {
          return Optional.of(str + "raj");
        })
        .orElse(Optional.of("raj"));
  }

  /**
   * @param list <- 1, 2, 7, 10
   * @return
   */
  static List<Integer> mulBy10(List<Integer> list) {
//    List<Integer> l = new ArrayList<>();
//    for (int i : list) {
//      if (i > 5) {
//        l.add(i * 10);
//      }
//    }
//    return l;

    return list.stream().filter(x -> x > 5).map(x -> x * 10).collect(Collectors.toList());
  }
}