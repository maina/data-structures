package com.test;

public class Main {

    public static void main(String[] args) {
     BinaryTree tree= new BinaryTree();
     tree.add(20);
     tree.add(10);
     tree.add(30);
     tree.add(6);
     tree.add(14);
     tree.add(24);
     tree.add(3);
     tree.add(8);
     tree.add(26);

System.out.println("leaves "+tree.areSiblings(6,14));

    }


}
