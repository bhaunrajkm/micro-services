package com.bhanu.workbook.dp;

public class WaterTaping {
    public static void main(String[] args) {
        int[] data = new int[]{3, 0, 2, 0, 4};
        //output: 1
        //T.C=O(n) , A.S.C=O(1)

        int lMax = 0, rMax = 0, water = 0, i = 0, j = data.length - 1;

        while (i < j) {
            if (data[i] < data[j]) {
                if (data[i] > lMax) {
                    lMax = data[i];
                } else {
                    water += lMax - data[i];
                }
                i++;
            } else {
                if (data[j] > rMax) {
                    rMax = data[j];
                } else {
                    water += rMax - data[j];
                }
                j--;
            }
        }

        System.out.println(water);
    }
}
