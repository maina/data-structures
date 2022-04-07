package com.test;

import java.util.Arrays;

public class ArrayExercise {
    public void rotLeft(int a[],int d){
        int size=a.length;
        while(d>0){
            int firstItem=a[0];
            for (int i=0;i<size-1;i++) {

                a[i] = a[i+1];
            }
            a[size-1]=firstItem;
            d--;
            System.out.println(Arrays.toString(a));

        }

    }
    public void moveZerosToLeft(int [] array){
        int counter=0;
        for(int i=counter;i<array.length;i++){
            if(array[i]==0){
               for(int j=i;j>0;j--){
                   array[j]=array[j-1];
               }
               array[0]=0;
            }
            counter++;
        }
System.out.println(Arrays.toString(array));
    }

}
