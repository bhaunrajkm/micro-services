package com.bhanu.workbook.genericJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxElementIndexes {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);

        List<Integer> r = new ArrayList<>();
        r.add(0);
        r.add(2);
        //Output [2,0]

        System.out.println(getMaxElementIndexes(a, r));
    }


    public static List<Integer> getMaxElementIndexes(List<Integer> a,
                                                     List<Integer> rotate) {
        List<Integer> result = new ArrayList<>();
        for (int i : rotate) {
            for (int j = 0; j < i; j++) {
                int t = a.get(0);
                a.remove(0);
                a.add(t);
            }
            int max = 0;
            int index = 0;
            for (int k = 0; k < a.size(); k++) {
                if (a.get(k) > max) {
                    max = a.get(k);
                    index = k;
                }
            }
            result.add(index);
        }
        return result;
    }


}
