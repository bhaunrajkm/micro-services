package com.bhanu.workbook.genericJava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Demo {
  public static void main(String[] args) {

    BigDecimal b1 = BigDecimal.valueOf(10);
    BigDecimal b2 = BigDecimal.valueOf(3);

    BigDecimal v = b1.divide(b2);

    List<Emp> emps = new ArrayList<>();

    List<Emp> filtered = emps
        .stream()
        .filter(x -> x.getAge() > 10)
        .collect(Collectors.toList());
    List<Emp> emps1 = new ArrayList<>();
    emps1.addAll(filtered);


    for (Emp e : filtered) {
      System.out.println(e);
    }

  }

  @Getter
  @Setter
  @Builder
  private static class Emp {
    int age;
  }
}
