package com.test;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = quickSort.sort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted, int start, int end) {
        if (start >= end) { // empty array  start>end or single item array start==end
            return unSorted;
        }

        var bIndex = partition(unSorted, start, end);

        sort(unSorted, start, bIndex - 1);
        sort(unSorted, bIndex + 1, end);
        return unSorted;
    }

    private int partition(int[] unSorted, int start, int end) {
        var bIndex = start - 1;
        var pivot = unSorted[end];
        for (var i = start; i <= end; i++) {
            if (unSorted[i] <= pivot) {
                swap(++bIndex, i, unSorted);
            }

        }
        return bIndex;
    }

    private void swap(int leftIndex, int rightIndex, int[] array) {
        var temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
