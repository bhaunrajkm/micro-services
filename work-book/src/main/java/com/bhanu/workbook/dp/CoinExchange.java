package com.bhanu.workbook.dp;

public class CoinExchange {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int amount = 5;
        //output: 5

        int r = a.length + 1;
        int c = amount + 1;


        int[][] dp = new int[r][c];

        for (int i = 0; i < r; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int diff = j - a[i - 1];
                int sum = dp[i - 1][j];
                if (diff >= 0) {
                    sum += dp[i][diff];
                }
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[r-1][c-1]);
    }
}
