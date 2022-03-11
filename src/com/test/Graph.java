package com.test;

import java.util.*;

public class Graph {
    public static void main(String[] args ){
        Graph graph= new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("A","D");
        graph.addEdge("C","D");
        graph.addEdge("A","E");
        graph.traverseDepthFirst("A");
    }
    private class Node {
        String label;

        public Node(String _label) {
            this.label = _label;
        }

    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();


    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(String label) {

    }

    public void addEdge(String from, String to) {
        var nodeFrom = nodes.get(from);
        var nodeTo = nodes.get(to);
        adjacencyList.get(nodeFrom).add(nodeTo);

    }

    public void removeEdge(String from, String to) {

    }

    public void traverseDepthFirst(String root) {
        traverseDepthFirst(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root.label);
        visited.add(root);
        for(var node: adjacencyList.get(root)){
            if(!visited.contains(node)){
               traverseDepthFirst(node,visited);
            }
        }
    }
}
