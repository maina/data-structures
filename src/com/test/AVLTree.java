package com.test;

public class AVLTree {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(30);
        avlTree.insert(10);
        avlTree.insert(20);
    }

    AVLNode root;

    private static class AVLNode {
        private final int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
        root = balance(root);

        return root;
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0) {
                System.out.println("isLeftHeavy Rotate left " + root.leftChild.value);
                return leftRightRotate(root);
            } else {
                System.out.println("isLeftHeavy Rotate right " + root.value);
            }
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) < 0)
                System.out.println("isRightHeavy Rotate root left " + root.value);
            else {
                System.out.println("isRightHeavy Rotate right rightchild " + root.rightChild.value);
            }
        }
        return root;
    }

    private AVLNode leftRightRotate(AVLNode root) {
        var middleNode = root.leftChild;
        var lastNode = middleNode.rightChild;

        lastNode.leftChild = middleNode;
        lastNode.rightChild = root;
        setHeight(lastNode);
        setHeight(root);
        return lastNode;

    }
    private void setHeight(AVLNode node){
        node.height=Math.max(node.leftChild.height,node.rightChild.height)+1;

    }

    private int balanceFactor(AVLNode root) {
        return height(root.leftChild) - height(root.rightChild);
    }

    private boolean isLeftHeavy(AVLNode root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root) {
        return balanceFactor(root) < -1;
    }

    private int height(AVLNode root) {
        return root == null ? -1 : root.height;
    }
}
