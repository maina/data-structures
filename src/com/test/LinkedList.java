package com.test;

public class LinkedList {
    private class Node {
         int value;
         Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;

    public void addLast(int item){
        var node = new Node(item);
        if(first==null){
            first=last=node;
        }else{
            last.next=node;
            last=node;
        }
    }
    public void removeFirst(){
        var second=first.next;
        first.next=null;
        first=second;
    }
    public void addFirst(int item){
        var node = new Node(item);
        if(first==null){
            first=last= node;
        }else{
            node.next=first;
            first=node;

        }
    }
    public int indexOf(int item){
        var counter=0;
        var currentNode=first;
        while(currentNode!=null){

            if(currentNode.value==item){
               return  counter;
            }
                currentNode=currentNode.next;
            counter ++;
        }
        return -1;
    }
    public void removeLast(){
        var current=first;

        while(current !=null){
            if(current.next==last){
                last=current;
                last.next=null;
                break;
            }
            current=current.next;
        }
    }
}
