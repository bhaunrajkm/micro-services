package com.bhanu.workbook.dp;

import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;

public class ClosestSum {
    public static void main(String[] args) {
        int[] a = {7, 4, 1, 10};
        int[] b = {4, 5, 8, 7};
        int sum = 13;
        //T.C: n(log n), S.C: O(n)
        //Output: (4, 8) (7, 5) (7, 7) (10, 4)

        int[][] dp = new int[a.length][b.length];
        Arrays.sort(a);
        Arrays.sort(b);

        int row = a.length;
        int col = b.length;

        int i = 0, j = col - 1;
        for (; i < row; ) {
            for (; j >= 0; ) {
                dp[i][j] = a[i] + b[j];
                if (dp[i][j] < sum) {
                    i++;
                } else if (dp[i][j] > sum) {
                    j--;
                }
            }
            if (j < 0 || i >= row) {
                break;
            }
        }

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (dp[i][j] == sum - 1 || dp[i][j] == sum + 1) {
                    System.out.println(a[i] + " " + b[j]);
                }
            }
        }
    }
}
