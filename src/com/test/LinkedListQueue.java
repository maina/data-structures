package com.test;

public class LinkedListQueue {
    private class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    Node first;
    Node last;
    public void enqueue(int item){
        var node= new Node(item);
        if(first==null){
            first=last=node;

        }else{
            last.next=node;
            last=node;
        }
    }

    public void dequeue(){
        System.out.println("Dequeue");
        var second=first.next;
        first=null;
        first=second;
    }
    public void print() {
        var node = first;
        while (node != null) {
            System.out.println(node.value);
            if (node.next != null) {
                node = node.next;

            } else {
                node = null;
            }


        }
    }
}
