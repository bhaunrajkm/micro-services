package com.bhanu.workbook.dp;

/**
 * https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 */
public class PetrolPuzzle {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{3, 1};
        int n = a.length;
        //output: 1

        int start = 0, end = 1;
        int tank = a[start] - b[start];

        while (start != end || tank < 0) {

            //dequeue till end
            while (start != end && tank < 0) {
                tank -= a[start] - b[start];

                start = (start + 1) % n;

                if (start == 0) {
                    System.out.println(-1);
                    return;
                }
            }
            tank += a[end] - b[end];
            end = (end + 1) % n;
        }

        System.out.println(start);
    }
}
