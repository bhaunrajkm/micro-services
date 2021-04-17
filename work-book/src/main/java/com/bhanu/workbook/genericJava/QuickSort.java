package com.bhanu.workbook.genericJava;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {10, 5, 7, 12, 1, 19, 5};
        //T.C in best and average : O(nlogn)
        //T.C in worst case O(n^2) - When elements are in ascending order descending order

        int i = 0, j = a.length - 1;

        sort(i, j, a);
    }

    private static void sort(int i, int j, int[] a) {
        if (i > j)
            return;

        int p = partition(i, j, a);
        sort(i, p - 1, a);
        sort(p + 1, j, a);
    }

    private static int partition(int i, int j, int[] a) {
        int p = i;

        while (i < j && i >= 0 && j < a.length) {
            while (i < a.length && a[i] <= a[p]) {
                i++;
            }

            while (j >= 0 && a[j] > a[p]) {
                j--;
            }

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            } else {
                int temp = a[p];
                a[p] = a[j];
                a[j] = temp;
                p = j;
            }
        }

        return p;
    }
}
