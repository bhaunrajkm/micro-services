package com.bhanu.workbook.dp;

public class TradingMaximumProfit {
    public static void main(String[] args) {
        int[] a = {13, 14, 18, 10, 12, 16, 9, 10};
        //Output: 6
        //T.C: O(n)

        int min = a[0];
        int maxProfit = 0;
        int sellIndex = 0;
        int buyPrice = a[0];

        for (int i = 1; i < a.length; i++) {
            if ((a[i] - min) > maxProfit) {
                maxProfit = a[i] - min;
                buyPrice = min;
                sellIndex = i;
            }

            if (a[i] < min) {
                min = a[i];
            }
        }
        System.out.println(a[sellIndex] - buyPrice);
    }
}
