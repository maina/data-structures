package com.test;

import java.util.Arrays;

public class PrioritizedQueue {

    int[] queue;
    int count = 0;


    public static void main(String[] args) {
        PrioritizedQueue queue= new PrioritizedQueue(10);
        queue.enqueue(15);
        queue.enqueue(4);
        queue.enqueue(12);
        queue.enqueue(1);
        System.out.println("done");
    }


    public PrioritizedQueue(int capacity) {
        queue = new int[capacity];
    }
public void enqueue(int item){
    int i=0;
        if(count==queue.length){
            throw new IllegalStateException("Queue is full");
        }
        if(count==0){
            queue[0]=item;
        }else{

            for( i=(count-1);i>=0;i--) {
                if(queue[i]>item){
                    //push to the right
                    queue[i+1]=queue[i];
                }else{

                    break;
                }
            }
        }
    queue[i+1]=item;
        count ++;
}

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
