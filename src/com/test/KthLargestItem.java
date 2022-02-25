package com.test;

import java.util.Arrays;

public class KthLargestItem {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 1, 2};

        KthLargestItem heap = new KthLargestItem();
        var sorted = heap.insert(array);
        System.out.println("Sorted array" + Arrays.toString(sorted));

    }

    private int[] insert(int[] array) {
        var sortedArray = new int[array.length];
        for (var i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
            var index = i;

            while (index > 0 && sortedArray[index] > sortedArray[parent(index)]) {
                swap(sortedArray, index, parent(index));
                index = parent(index);
            }

        }
        return sortedArray;

    }
    private void remove(int[] array){



    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
    private void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;

    }


}
