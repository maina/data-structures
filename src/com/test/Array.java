package com.test;

public class Array {
    int [] array;
    int arraySizCounter=0;
    public Array(int size){
        array= new int[size];

    }
    public void insert(int value){
        if(arraySizCounter==0){
            array[0]=value;

        }else if(arraySizCounter<array.length){
            array[arraySizCounter]=value;
        }
            else {
            int size = array.length + 1;
            int[] newArray = new int[size];
            for (int i = 0; i < arraySizCounter; i++) {
                newArray[i] = array[i];
            }
            newArray[size - 1] = value;
            array = newArray;
        }
        arraySizCounter++;
    }
    public void removeAt(int index){
        for(int i=index;i<arraySizCounter;i++){

            array[i]=array[i+1];
        }
        arraySizCounter--;
    }
    public void reverse(){
        int counter=arraySizCounter-1;
        while(counter>-1){
            System.out.println(array[counter]);
            counter--;
        }
    }
    public void max(){
        int max=0;
        for(int i=0;i<arraySizCounter;i++){

            if(array[i]>max){
                max=array[i];
            }
        }
        System.out.println(max);
    }

    public void intersect(int [] anotherArray){
        if(anotherArray.length>array.length){
            for(int i=0;i<anotherArray.length;i++){
                int searchValue=anotherArray[i];
                for(int j=0;j<arraySizCounter;j++){
                    if(array[j]==searchValue){
                        System.out.println("Common value "+searchValue);
                        break;
                    }
                }
            }
        }else{
            for(int i=0;i<arraySizCounter;i++){
                int searchValue=array[i];
                for(int j=0;j<anotherArray.length;j++){
                    if(anotherArray[j]==searchValue){
                        System.out.println("Common value "+searchValue);
                        break;
                    }
                }
            }
        }

    }
    public void insertAt(int item,int index){
            if(array.length==arraySizCounter){
                int [] newArray= new int[arraySizCounter+1];
                for (int i = 0; i < arraySizCounter; i++) {
                    newArray[i] = array[i];
                }
                array= newArray;
            }

      for(int i=arraySizCounter-1;i>=index;i--){
          array[i+1]=array[i];

      }
      array[index]=item;
    }
    public void print(){
        for (int j : array) {
            System.out.println(j);
        }
    }
    public void moveZeroes(int[] nums){
        int nonZeroPointer=0;
        for(int i=0;i<=nums.length-1;i++){
            var currentValue=nums[i];
            if(currentValue>0 && i>0){
                if(nums[0]>0){
                    nonZeroPointer++;
                }
                nums[nonZeroPointer]=currentValue;
                nums[i]=0;


            }
        }
        array=nums;
        print();
    }
}
