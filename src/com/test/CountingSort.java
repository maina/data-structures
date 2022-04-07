package com.test;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] unsortedArray = {7, 1, 3, 4, 6, 2, 3};
        var array = countingSort.sort(unsortedArray, 8);
        System.out.println(Arrays.toString(array));
    }

    private int[] sort(int[] unSorted, int max) {
      int [] indexArray= new int[max];
      for(var i: unSorted){
          indexArray[i]++;
      }
      var index=0;
      for(var i=0; i< indexArray.length;i++){
          for(var j=0; j<indexArray[i];j++){
              unSorted[index++]=i;
          }
      }

        return unSorted;
    }
}
