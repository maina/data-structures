package com.test;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] unsortedArray = {7,1,3,4,6,2,3};
        var array = bubbleSort.sort(unsortedArray);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted) {
        for (int i = 0; i < unSorted.length; i++) {
            for (var j = 1; j < unSorted.length; j++) {
                if (unSorted[j] < unSorted[j - 1]) {
                    var value = unSorted[j];
                    unSorted[j] = unSorted[j - 1];
                    unSorted[j - 1] = value;

                }
            }
        }
        return unSorted;
    }
}
