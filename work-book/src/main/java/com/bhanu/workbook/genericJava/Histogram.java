package com.bhanu.workbook.genericJava;

import java.util.Stack;

public class Histogram {
    public static void main(String[] args) {
        int[] a = new int[]{3, 0, 4, 4, 3};
        //T.C: 2^n -> O(n)

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        while (i < a.length) {
            if (stack.isEmpty() || a[stack.peek()] <= a[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = a[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = a[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }
}
