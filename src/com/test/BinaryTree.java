package com.test;

public class BinaryTree {

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node " + value;
        }
    }

    Node root;

    public void add(int value) {
        var node = new Node(value);
        if (root == null) {

            root = node;
        } else {
            var currentNode = root;
            while (true) {


                if (currentNode.value > value) {
                    var leftChild = currentNode.left;
                    if (leftChild == null) {
                        currentNode.left = node;

                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    var rightChild = currentNode.right;
                    if (rightChild == null) {
                        currentNode.right = node;
                        break;

                    } else {
                        currentNode = currentNode.right;
                    }
                }


            }
        }
    }

    public boolean find(int value) {
        var currentNode = root;
        boolean exists = false;
        while (currentNode != null) {

            if (currentNode.value == value) {
                exists = true;
                currentNode = null;
            } else {

                if (currentNode.value > value) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

        }
        return exists;
    }

    public void preOrderTraversal() {
        System.out.println("preOrderTraversal");
        preOrderTraversal(root);
    }

    public void inOrderTraversal() {
        System.out.println("inOrderTraversal");
        inOrderTraversal(root);
    }

    public void postOrderTraversal() {
        System.out.println("postOrderTraversal");

        postOrderTraversal(root);
    }

    private void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    private void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);

    }


    public void nodesAtKthDistance(Node root, int distance) {
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }

        nodesAtKthDistance(root.left, distance - 1);
        nodesAtKthDistance(root.right, distance - 1);
    }

    public void nodesAtKthDistance(int distance) {

        nodesAtKthDistance(root, distance);
    }

    public void swapRoot() {
        var node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public boolean isBst(Node root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max) {
            return false;
        }
        return isBst(root.left, min, root.value - 1) && isBst(root.right, root.value + 1, max);

    }

    public boolean isBst() {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int leaves = 0;

    private void countLeaves(Node root) {
        if (root == null) {

            return;
        } else {
            leaves = leaves + 1;
        }
        countLeaves(root.left);
        countLeaves(root.right);

    }

    public int countLeaves() {

        countLeaves(root);

        return leaves;
    }

    int max = 0;

    private void max(Node root) {
        if (root == null) {
            return;
        } else {
            if (root.value > max) {
                max = root.value;
            }
        }
        max(root.left);
        max(root.right);
    }

    public int max() {
        max(root);
        return max;
    }

    public boolean contains(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }
        return contains(root.left, value) || contains(root.right, value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    public boolean areSiblings(Node root, int leftVal, int rightVal) {
        if (root == null) {
            return false;
        }
        if (root.right.value == rightVal && root.left.value == leftVal) {
            return true;
        }
        return areSiblings(root.left, leftVal, rightVal) || areSiblings(root.right, leftVal, rightVal);
    }

    public boolean areSiblings(int leftVal, int rightVal) {
        return areSiblings(root, leftVal, rightVal);
    }


}
