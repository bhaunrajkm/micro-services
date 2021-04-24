package com.bhanu.workbook.genericJava;

import java.util.Arrays;
import java.util.List;

public class SpaceSeparatedSequence {
    public static void main(String[] args) {
        String s1 = "myinterviewtrainer";
        List<String> dict = Arrays.asList("trainer", "my", "interview");

        int i = 0, j = 1;
        while (j <= s1.length()) {
            String sub = s1.substring(i, j);
            if (dict.contains(sub)) {
                i = j;
            }
            j++;
        }

        if (i == s1.length()) {
            System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        }
    }
}
