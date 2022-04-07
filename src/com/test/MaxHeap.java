package com.test;

import java.util.Arrays;

public class MaxHeap {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 1, 2};
        MaxHeap heap = new MaxHeap();
        for(var i=0;i<array.length;i++){
            heap.heapify(array,i);
        }
        System.out.println("heapified "+ Arrays.toString(array));
        optimized(array);

    }
    public static void optimized(int[] array){
        MaxHeap heap = new MaxHeap();
        for(var i=(array.length/2 -1);i>=0;i--){
            heap.heapify(array,i);
        }
        System.out.println("optimized heapified "+ Arrays.toString(array));
    }


    public void heapify(int[] heapArray,int index) {
        //bubble down

        var largerIndex = index;
        var leftIndex = index * 2 + 1;
        var rightIndex = index * 2 + 2;
        if (leftIndex<heapArray.length && heapArray[leftIndex] > heapArray[largerIndex]) {
            largerIndex = leftIndex;

        } else if (rightIndex<heapArray.length && heapArray[rightIndex] > heapArray[largerIndex]) {
            largerIndex = rightIndex;

        }
        if(index==largerIndex){
            return;
        }

        swap(heapArray,largerIndex, index);
        heapify(heapArray,largerIndex);

    }

    private void swap(int[] heapArray,int firstIndex, int secondIndex) {
        var temp = heapArray[secondIndex];
        heapArray[secondIndex] = heapArray[firstIndex];
        heapArray[firstIndex] = temp;
    }



}
