package com.bhanu.workbook.dp;

public class MaxSquareInMatrix {
    public static void main(String[] args) {
        int[][] a = {{0, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 1}, {1, 0, 1, 1, 1}};
        //T.C: O(row * col)

        int row = a.length + 1;
        int col = a[0].length + 1;
        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (a[i - 1][j - 1] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }
}
