package com.bhanu.workbook.genericJava;

public class LongestEvenWord {
    public static void main(String[] args) {
        System.out.println(findLongestEvenWord("be not afraid of greatness"));
    }

    public static String findLongestEvenWord(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return "";
        }

        String maxString = "";
        int max = 0;

        for (String s : sentence.split(" ")) {
            if (s.length() > max
                    && s.length() % 2 == 0) {
                maxString = s;
                max = s.length();
            }
        }

        return maxString;
    }
}
