package com.bhanu.workbook.genericJava;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/sum-of-all-subarrays/
 */
public class SubArraySum {
    public static void main(String[] args) {
        System.out.println(subArraySum(Arrays.asList(4, 5, 6)));
    }

    public static long subArraySum(List<Integer> arr) {
        long result = 0;
        for (int i = 0; i < arr.size(); i++)
            result += (arr.get(i) * (i + 1) * (arr.size() - i));

        return result;
    }
}
