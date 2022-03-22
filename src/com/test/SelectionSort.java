package com.test;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] unsortedArray = {7,1,3,4,6,2,3};
        var array = selectionSort.sort(unsortedArray);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted) {

        for (int i = 0; i < unSorted.length; i++) {
            int smallestValue=unSorted[i];
            int index=i;
            for (int j = i; j < unSorted.length; j++) {
                if (unSorted[j] < smallestValue) {
                    smallestValue=unSorted[j];
                    index=j;
                }
            }
            int temp=unSorted[i];
            unSorted[i]=smallestValue;
            unSorted[index]=temp;

        }
        return unSorted;
    }
}
