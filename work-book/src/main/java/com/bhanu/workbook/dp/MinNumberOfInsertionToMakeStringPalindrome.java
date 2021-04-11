package com.bhanu.workbook.dp;

public class MinNumberOfInsertionToMakeStringPalindrome {
    public static void main(String[] args) {
        final String str = "abdcae";
        //output: 3

        int dp[][] = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(helper(str, 0, str.length() - 1, dp));
    }

    private static int helper(String s, int start, int end, int[][] dp) {
        if (start >= end)
            return 0;

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) {
            return helper(s, start + 1, end - 1, dp);
        }

        int l = helper(s, start + 1, end, dp);
        int r = helper(s, start, end - 1, dp);
        dp[start][end] = 1 + Math.min(l, r);
        return dp[start][end];
    }
}
