package com.bhanu.workbook.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=aPQY__2H3tE
 * Ai[Li,Wi,Hi]
 */
public class MaxStackFromTheGivenBoxes {
    public static void main(String[] args) {
        List<List<Integer>> boxes = Arrays.asList(Arrays.asList(4, 5, 3),
                Arrays.asList(2, 3, 2),
                Arrays.asList(3, 6, 2),
                Arrays.asList(1, 5, 4),
                Arrays.asList(2, 4, 1),
                Arrays.asList(1, 2, 2));
        //Output: 7
        //T.C: O(n)

        Collections.sort(boxes, Comparator.comparingInt(x -> x.get(0)));

        int[] h = new int[boxes.size()];

        for (int i = 0; i < boxes.size(); i++) {
            h[i] = boxes.get(i).get(2);
        }

        for (int i = 1; i < boxes.size(); i++) {
            int maxHeight = 0;

            for (int j = 0; j <= i; j++) {
                if (boxes.get(i).get(0) > boxes.get(j).get(0)
                        && boxes.get(i).get(1) > boxes.get(j).get(1)
                        && h[j] > maxHeight) {
                    maxHeight = h[j];
                }
            }

            h[i] += maxHeight;
        }

        Arrays.sort(h);
        System.out.println(h[h.length - 1]);
    }
}
