package com.bhanu.workbook.dp;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] a = new int[]{3, 10, 2, 1, 20, 15};
        //output: 3

        int[] dp = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
        }

        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] <= dp[j]) {
                    dp[i] += 1;
                    if (dp[i] > max) {
                        max = dp[i];
                    }
                }
            }
        }

        System.out.println(max);
    }
}
