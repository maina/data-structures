package com.test;

import java.util.Arrays;

public class Heapify {
    int [] heapArray;

    public static void main(String[] args) {
        int [] array= {5,3,8,4,1,2};
        Heapify heap = new Heapify(array);
        var heapified=heap.heapify();
        System.out.println("heapified "+Arrays.toString(heapified));

    }
    public Heapify(int [] array){
        heapArray=array;
    }
    public int[] heapify(){
        for(var i=0;i<heapArray.length;i++){
bubbleUp(i);
        }
        return heapArray;
    }
    private void bubbleUp(int index){
        int parentIndex= parentIndex(index);

        while(parentIndex>=0 && heapArray[index]>heapArray[parentIndex]){
            swap(parentIndex,index);
            index=parentIndex;
            parentIndex=parentIndex(index);
        }
    }
    private void swap(int parentIndex, int childIndex){
        var temp=heapArray[childIndex];
        heapArray[childIndex]=heapArray[parentIndex];
        heapArray[parentIndex]=temp;
    }
    private int parentIndex(int index){
        return (index-1)/2;
    }
}
