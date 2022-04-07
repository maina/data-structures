package com.test;

import java.util.Arrays;

public class ExponentialSearch {

    public static void main(String[] args) {
        ExponentialSearch exponentialSearch = new ExponentialSearch();
        int[] unsortedArray =  {7, 1, 3, 4, 6, 2, 3};
        var array = exponentialSearch.quicKSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("sorted value " + Arrays.toString(array));
        System.out.println("search result " + exponentialSearch.search(array, 7));
    }

    private int search(int[] unSortedArray, int searchValue){
        var exponential=1;
        while(exponential<=unSortedArray.length){
            if(searchValue<=unSortedArray[exponential]){
               return binarySearch(unSortedArray,exponential/2,exponential,searchValue);
            }
            exponential*=2;
            if(exponential>unSortedArray.length){
                exponential=unSortedArray.length-1;
            }

        }
        return -1;
    }


    private int binarySearch(int[] unSortedArray, int left, int right, int searchValue){

        var middle = (left+right)/2;
        if(unSortedArray[middle]==searchValue){
            return middle;
        }
        if(searchValue<unSortedArray[middle]){
           return binarySearch(unSortedArray,left, middle-1,searchValue);
        }
        if(searchValue>unSortedArray[middle]){
            return binarySearch(unSortedArray,middle+1,right,searchValue);
        }

        return -1;
    }






    private int[] quicKSort(int[] unSortedArray, int start, int end) {
        if (start >= end) {
            return unSortedArray;
        }
        var boundary = partition(unSortedArray, start, end);
        quicKSort(unSortedArray, start, boundary - 1);
        quicKSort(unSortedArray, boundary + 1, end);
        return unSortedArray;
    }

    private int partition(int[] unSortedArray, int start, int end) {
        var boundary = start - 1;
        var pivot = unSortedArray[end];
        for (var i = start; i <= end; i++) {
            if (unSortedArray[i] <= pivot) {
                swap(unSortedArray, ++boundary, i);
            }
        }
        return boundary;
    }

    private void swap(int[] unSortedArray, int leftIndex, int rightIndex) {
        var temp = unSortedArray[leftIndex];
        unSortedArray[leftIndex] = unSortedArray[rightIndex];
        unSortedArray[rightIndex] = temp;
    }
}
