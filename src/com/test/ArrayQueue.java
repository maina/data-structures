package com.test;

import java.util.Arrays;

public class ArrayQueue {
    int [] queue;
    int count=0;
    int rear=0;
    int front=0;
    public static void main(String[] args) {
        ArrayQueue queue= new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

    }
    public ArrayQueue(int capacity){
        queue= new int[capacity];
    }
    public void enqueue(int item){

        if(count==queue.length){
           throw new IllegalStateException("Array is full");
        }

        queue[rear]=item;
        rear= (rear+1)%queue.length;
        count++;
    }
    public void dequeue(){

        queue[front]=0;
        front=(front+1)%queue.length;
        count--;
    }
    @Override
    public String toString(){
        return Arrays.toString(queue);
    }

}
