package com.bhanu.workbook.genericJava;

import javafx.print.Collation;
import sun.text.resources.sk.CollationData_sk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Top3Occurrence {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7};

        Map<Integer, Integer> map = new HashMap<>();
        for (int item : a) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        //3
        Map<Integer, Integer> tMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tMap.put(entry.getValue(), entry.getKey());
        }

        int count = 0;
        for (int i : tMap.values()) {
            System.out.println(i);
            count++;
            if (count == 3) {
                break;
            }
        }
    }
}
