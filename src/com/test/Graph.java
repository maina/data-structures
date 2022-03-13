package com.test;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addNode("E");
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "C");
//        graph.addEdge("A", "D");
//        graph.addEdge("C", "D");
//        graph.addEdge("A", "E");
//        // graph.traverseDepthFirst("A");
//        graph.traverseBreadthFirst("A");
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X","A");
        graph.addEdge("X","B");
        graph.addEdge("A","P");
        graph.addEdge("B","P");
        System.out.println(graph.topoligicalSort());
    }

    private class Node {
        private String label;

        public Node(String _label) {
            this.label = _label;
        }

        @Override
        public String toString() {
            return  "node "+label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();
    private Stack<Node> nodeStack = new Stack<>();

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
        for (var node : adjacencyList.get(root)) {
            if (!visited.contains(node)) {
                traverseDepthFirst(node, visited);
            }
        }
    }

    //    private void traverseDepthFirstByIteration(Node root){
//        System.out.println(root.label);
//        nodeStack.add(root);
//
//        while(!nodeStack.isEmpty()){
//            var node=adjacencyList.get(nodeStack.pop());
//            nodeStack.add(node.get(0));
//        }
//    }
    public void traverseBreadthFirst(String root) {
        traverseBreadthFirst(nodes.get(root), new HashSet<>());
    }

    public void traverseBreadthFirst(Node root, Set<Node> visited) {
        var queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current.label);
            for (var neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
            visited.add(current);
        }
    }

    public List<Node> topoligicalSort() {
        var visited = new HashSet<Node>();
        var stack = new Stack<Node>();
        for (var node : nodes.values()) {
            topologicalSort(node, visited, stack);
        }
        List<Node> sorted = new ArrayList<>();

        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }
        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        for (var neighbor : adjacencyList.get(node)) {
            topologicalSort(neighbor, visited, stack);
        }
        stack.add(node);
    }
}
