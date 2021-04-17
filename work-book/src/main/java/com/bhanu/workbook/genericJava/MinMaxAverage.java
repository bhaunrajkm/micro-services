package com.bhanu.workbook.genericJava;

import java.util.ArrayList;
import java.util.List;

public class MinMaxAverage {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);


        int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = list.stream().mapToInt(Integer::intValue).min().getAsInt();
        double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("avg: " + avg);
    }
}
