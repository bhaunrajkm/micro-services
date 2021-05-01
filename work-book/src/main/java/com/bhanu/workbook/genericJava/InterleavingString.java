package com.bhanu.workbook.genericJava;

public class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcca"; //-> m
        String s2 = "bac";    //-> n
        String s3 = "aabacbcca"; // -> m + n
        //Output: true
        //T.C: O(2^m+n)

        if (s1.length() + s2.length() == s3.length()
                && match(s1, s2, s3, 0, 0, 0)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static boolean match(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return s1.length() == i && s2.length() == j;
        }

        if (i == s1.length()) {
            return s2.charAt(j) == s3.charAt(k) && match(s1, s2, s3, i, j + 1, k + 1);
        }

        if (j == s2.length()) {
            return s1.charAt(i) == s3.charAt(k) && match(s1, s2, s3, i + 1, j, k + 1);
        }

        boolean s1Match = false, s2Match = false;
        if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            s1Match = match(s1, s2, s3, i + 1, j, k + 1);
            s2Match = match(s1, s2, s3, i, j + 1, k + 1);
        } else if (s1.charAt(i) == s3.charAt(k)) {
            s1Match = match(s1, s2, s3, i + 1, j, k + 1);
        } else if (s2.charAt(j) == s3.charAt(k)) {
            s2Match = match(s1, s2, s3, i, j + 1, k + 1);
        }

        return s1Match || s2Match;
    }
}
