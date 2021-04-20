package com.bhanu.workbook.dp;

public class MinimumJumsToReachEndOfTheArray {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        //T.C: O(n^2)

        int col = a.length;
        int row = col;
        int[][] dp = new int[row][col];

        for (int j = 1; j < col; j++) {
            for (int i = 0; i < j; i++) {
                if (j - (i + a[i]) <= 0) {
                    dp[i][j] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    int x = j - (i + a[i]);
                    for (int k = 0; k < row; k++) {
                        if (dp[k][x] != 0 && dp[k][x] < min) {
                            min = dp[k][x];
                        }
                    }
                    dp[i][j] = 1 + min;
                }
            }
        }

        System.out.println(dp[0][col - 1]);
    }
}
