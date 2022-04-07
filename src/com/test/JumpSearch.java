package com.test;

import java.util.Arrays;

public class JumpSearch {

    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = jumpSearch.quicKSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("sorted value " + Arrays.toString(array));
        System.out.println("search result " + jumpSearch.search(array, 1));
    }

    private int search(int[] unsortedArray, int searchValue) {
        int partitionSize = (int) Math.sqrt(unsortedArray.length);
        int left = 0;
        int right = partitionSize;
        while (right <unsortedArray.length) {
            if (searchValue <= unsortedArray[right]) {
                //iterate in the block
                for (var i = left; i <= right; i++) {
                    if (searchValue == unsortedArray[i]) {
                        return i;
                    }
                }
            }
            left+=partitionSize;
            right+=partitionSize;
        }
        return -1;
    }

    private int[] quicKSort(int[] unsortedArray, int start, int end) {
        if (start > end) {
            return unsortedArray;
        }
        var boundary = partition(unsortedArray, start, end);
        quicKSort(unsortedArray, start, boundary - 1);
        quicKSort(unsortedArray, boundary + 1, end);

        return unsortedArray;
    }

    private int partition(int[] unsortedArray, int start, int end) {
        int boundary = start - 1;
        var pivot = unsortedArray[end];
        for (var i = start; i <= end; i++) {
            if (unsortedArray[i] <= pivot) {
                swap(unsortedArray, ++boundary, i);
            }
        }
        return boundary;
    }

    private void swap(int[] array, int leftIndex, int rightIndex) {
        var temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;

    }
}
