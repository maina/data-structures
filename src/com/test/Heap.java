package com.test;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int [] numbers ={10,5,17,4,22};
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        //sort descending
      for(var i=0;i<numbers.length;i++){
          numbers[i]=heap.remove();
      }
        System.out.println(Arrays.toString(numbers));
      //sort ascending
        Heap heap2 = new Heap();
        heap2.insert(10);
        heap2.insert(5);
        heap2.insert(17);
        heap2.insert(4);
        heap2.insert(22);
        for(var i=numbers.length-1;i>=0;i--){
            numbers[i]= heap2.remove();

        }
        System.out.println(Arrays.toString(numbers));

    }

    private int[] heapArray = new int[5];
    private int count = 0;

    public void insert(int value) {

        if (count == heapArray.length) {
            throw new IllegalArgumentException("Array is full");
        }
        heapArray[count++] = value;
        bubbleUp(count - 1);


    }

    public int remove() {
        //replace first item with last
        var removedItem=heapArray[0];
        heapArray[0] = heapArray[--count];
        bubbleDown();
        System.out.printf("Removed %s%n",removedItem);
        return removedItem;
    }

    private void bubbleDown() {
        int index = 0;
        while (!isValidParent(index)) {
            //get which is larger btwn left and right children
            var largerIndex = largerIndex(index);
            swap(index, largerIndex);
            index = largerIndex;
        }

    }

    private int largerIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }
        if (!hasRightChild(index)) {
            return leftIndex(index);
        }
        return leftChild(index) > rightChild(index) ? leftIndex(index) : rightIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        if (!hasRightChild(index)) {
            return true;
        }
        return heapArray[index] >= leftChild(index) && heapArray[index] >= rightChild(index);
    }

    private int leftChild(int index) {
        return heapArray[leftIndex(index)];
    }

    private int leftIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightIndex(int index) {
        return (index * 2) + 2;
    }

    private int rightChild(int index) {
        return heapArray[rightIndex(index)];
    }

    private boolean hasRightChild(int index) {
        return rightIndex(index) <= count;
    }

    private boolean hasLeftChild(int index) {
        return leftIndex(index) <= count;
    }

    private void swap(int parentIndex, int childIndex) {
        var temp = heapArray[childIndex];
        heapArray[childIndex] = heapArray[parentIndex];
        heapArray[parentIndex] = temp;
    }

    private void bubbleUp(int index) {
        while (index > 0 && heapArray[index] > heapArray[parent(index)]) {
            //swap
            var temp = heapArray[parent(index)];
            heapArray[parent(index)] = heapArray[index];
            heapArray[index] = temp;
            index = parent(index);

        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

}
