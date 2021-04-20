package com.bhanu.workbook.dp;

/**
 * https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/
 */
public class DistinctOccurrenceOfSubSequence {
    public static void main(String[] args) {
        String s = "banana";
        String t = "ban";
        //output: 3
        //T.C = O(row * col)

        int row = t.length() + 1;
        int col = s.length() + 1;
        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }
}
