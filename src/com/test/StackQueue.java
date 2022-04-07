package com.test;

import java.util.Arrays;
import java.util.Stack;

public class StackQueue {
    private Stack<Integer> eStack= new Stack<>();
    private Stack<Integer> dStack= new Stack<>();

    public void enqueue(int item){
        eStack.push(item);
    }
    public void dequeue(){
        if(dStack.isEmpty()){
            while(!eStack.isEmpty()){
                dStack.push(eStack.pop());
            }

        }else{
            var holdingStack= new Stack<>();
            holdingStack.addAll(Arrays.asList(dStack.toArray()));
            dStack.clear();
            while(!eStack.isEmpty()){
                dStack.push(eStack.pop());
            }
            while(!holdingStack.isEmpty()){
                dStack.push(Integer.valueOf(holdingStack.pop().toString()));
            }
        }
        dStack.pop();
    }

    @Override
    public String toString()
    {
       return Arrays.toString(dStack.isEmpty()?eStack.toArray():dStack.toArray());
    }
}
