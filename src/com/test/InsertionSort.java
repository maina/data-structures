package com.test;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = insertionSort.sort(unsortedArray);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted) {

        for (int i = 1; i < unSorted.length; i++) {
           var current=unSorted[i];
           var index=i;


        }
        return unSorted;
    }
}
