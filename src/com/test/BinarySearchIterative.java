package com.test;

import java.util.Arrays;

public class BinarySearchIterative {
    public static void main(String[] args) {
        BinarySearchIterative binarySearchIterative = new BinarySearchIterative();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = binarySearchIterative.quicKSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("sorted value " + Arrays.toString(array));
        System.out.println("search result " + binarySearchIterative.search(array,  00));
    }

    private int search(int [] unsortedArray, int searchValue){
        int start=0;
        int end= unsortedArray.length-1;
        while(end>=start){
            var middle = (start+end)/2;
            if(searchValue==unsortedArray[middle]){
                return middle;
            }
            if(searchValue<unsortedArray[middle]){
                end=middle-1;
            }else{
                start= middle+1;
            }

        }
        return -1;
    }

    private int [] quicKSort(int [] unsortedArray, int start, int end){

        if(start>=end){
            return unsortedArray;
        }

        var boundary=partition(unsortedArray,start,end);
        quicKSort(unsortedArray,start,boundary-1);
        quicKSort(unsortedArray,boundary+1,end);

        return unsortedArray;

    }

    private int partition(int [] unsortedArray, int start, int end){
        var boundary= start-1;
        var pivot=unsortedArray[end];
        for(var i=start;i<=end;i++){
            if(unsortedArray[i]<=pivot){
                swap(unsortedArray,++boundary,i);
            }
        }
        return boundary;
    }
    private void swap(int [] array, int leftIndex, int rightIndex){
        var temp= array[leftIndex];
        array[leftIndex]=array[rightIndex];
        array[rightIndex]=temp;
    }
}
