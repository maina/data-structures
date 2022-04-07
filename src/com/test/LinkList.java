package com.test;

public class LinkList {
    private static class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    Node first;
    Node last;

    public void addFirst(int val) {
        var node = new Node(val);
        if (first == null) {
            first = last = node;
        } else {
            var second = first;
            first = node;
            node.next = second;
        }
    }

    public void addLast(int val) {
        Node node = new Node(val);
        if (first == null) {
            first = last = node;
        } else {
            last.next = null;
            last = node;

        }
    }

    public void deleteFirst() {
        var second = first.next;
        first.next = null;
        first = second;
    }

    public void deleteLast() {

        var current = first;
        while (current != null) {

            if (current.next == last) {
                last = current;
                last.next = null;

            }
            current = current.next;

        }

    }

    public void reverse() {
        var current=first.next;
        var previous=first;
        while(current!=null){
            var next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        first.next=null;
        last=first;
        first=previous;

    }
    public void getKthNode(int k){
        Node pointerOne=first;
        Node pointerTwo=first;
        for(int i=0;i<k;i++){
            pointerOne=pointerOne.next;
        }
        while(pointerOne!=null){
            pointerOne=pointerOne.next;
            pointerTwo=pointerTwo.next;
        }
        System.out.println(""+pointerTwo.value);
    }

    public void printMiddle(){
        var nodeCounter=first;
        var middleCounter= first;
        while(nodeCounter!=last && nodeCounter.next!=last){
            nodeCounter=nodeCounter.next.next;
            middleCounter=middleCounter.next;
        }
        if(nodeCounter!=null){
            //this is an even count linkedlist
            System.out.println("Middle nodes are: "+ middleCounter.next.value + " "+middleCounter.value );
        }else{
            System.out.println("Middle nodes is: "+ middleCounter.value  );

        }
    }

    public void print() {
        Node node = first;
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
