package com.test;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = mergeSort.sort(unsortedArray);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted) {
        if(unSorted.length<2){
            return unSorted;
        }
        var arraySize = unSorted.length;
        var middle = arraySize / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[arraySize - middle];
        for (var i = 0; i < middle; i++) {
            leftArray[i] = unSorted[i];
        }
        for (var j = middle; j < arraySize; j++) {
            rightArray[j - middle] = unSorted[j];
        }
        sort(leftArray);
        sort(rightArray);
        merge(leftArray,rightArray,unSorted);
        return unSorted;
    }
    private void merge(int[] left, int[] right, int [] array){
      int i=0;
        int j=0;
        int k=0;
        //compare arrays and copy small value to array
      while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                array[k++]=left[i++];

            }else{
                array[k++]=right[j++];
            }
      }
      // copy remaining values to array
        while(i<left.length){
            array[k++]=left[i++];
        }
        while(j<right.length){
            array[k++]=right[j++];
        }

    }
}
