package com.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Queues {
    private Queue<Integer> queue;
    public Queues(int size){
        queue= new ArrayDeque<>();
        while(size!=0){
            queue.add(size);
            size--;
        }
    }
    public void reverse(){
        var stack= new Stack<Integer>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        System.out.println(Arrays.toString(queue.toArray()));
    }
}
