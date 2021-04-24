package com.bhanu.workbook.dp;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "Anshuman";
        String s2 = "Antihuman";
        //Output: 2

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int distance = getDistance(dp, s1, s2, m-1, n-1);
        System.out.println(distance);
    }

    private static int getDistance(int[][] dp, String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n))
            return getDistance(dp, s1, s2, m - 1, n - 1);

        int d = 1 + Math.min(getDistance(dp, s1, s2, m, n - 1), Math.min(getDistance(dp, s1, s2, m - 1, n), getDistance(dp, s1, s2, m - 1, n - 1)));
        dp[m][n] = d;
        return d;
    }
}
