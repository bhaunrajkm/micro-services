package com.bhanu.workbook.dp;

import java.util.Stack;

public class MaxRectangleInMatrix {
    public static void main(String[] args) {
        int[][] a = {{1, 0, 0, 1, 1, 1}, {1, 0, 1, 1, 0, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1}};
        //T.C:

        int row = a.length;
        int col = a[0].length;

        int[] histi = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) {
                    histi[j] += 1;
                } else {
                    histi[j] = 0;
                }
            }
        }

        //Use Histogram logic to find rectangle
        Stack<Integer> stack = new Stack<>();
        int i = 0, maxArea = 0;

        while (i < col) {
            if (stack.isEmpty() || histi[stack.peek()] <= histi[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int area = histi[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = histi[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println(maxArea);
    }
}
