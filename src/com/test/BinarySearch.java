package com.test;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = binarySearch.quicKSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("sorted value " + Arrays.toString(array));
        System.out.println("search result " + binarySearch.search(array, 0, unsortedArray.length, 3));
    }

    private int search(int[] unSorted, int left, int right, int searchValue) {
        if (right < left) { // array is empty
            return -1;
        }
        var middle = (left + right) / 2;

        if (unSorted[middle] == searchValue) {
            return middle;
        }
        if (searchValue < unSorted[middle]) {
            return search(unSorted, left, middle - 1, searchValue);
        }
        if (searchValue > unSorted[middle]) {
            return search(unSorted, middle + 1, right, searchValue);
        }
        return -1;
    }

    private int[] quicKSort(int[] unSorted, int start, int end) {
        if (start >= end) {
            return unSorted;
        }
        var boundary = partition(unSorted, start, end);
        quicKSort(unSorted, start, boundary - 1);
        quicKSort(unSorted, boundary + 1, end);

        return unSorted;
    }

    private int partition(int[] unSorted, int start, int end) {
        var boundary = start - 1;
        var pivot = unSorted[end];
        for (var i = start; i <= end; i++) {
            if (unSorted[i] <= pivot) {
                swap(++boundary, i, unSorted);
            }
        }
        return boundary;
    }

    private int[] swap(int leftIndex, int rightIndex, int[] array) {
        var temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
        return array;
    }
}
