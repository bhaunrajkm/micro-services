package com.bhanu.workbook.dp;

/**
 * https://www.geeksforgeeks.org/wildcard-pattern-matching/
 */
public class WildCardPatternMatching {
    public static void main(String[] args) {
        String s = "baab";
        String p = "*a?b";
        //Output = true
        //T.C : O(row*col)

        int row = s.length() + 1;
        int col = p.length() + 1;

        int[][] dp = new int[row][col];

        dp[0][0] = 1;

        for (int i = 1; i < col; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        if (dp[row - 1][col - 1] > 0) {
            System.out.println(true);
        }
    }
}
