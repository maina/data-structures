package com.test;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private static final int ALPHABET_SIZE=26;

    public static void main(String[] args) {
        var trie= new Trie();
        trie.insertHash("book");
        System.out.println("word");
    }

    private static class Node {
        public char value;
        public boolean isEndOfWord;
        public Node [] children= new Node[ALPHABET_SIZE];
        public Node(char value){
            this.value=value;
        }
    }
    private static class HashNode {
        public char value;
        public boolean isEndOfWord;
        public Map<Character,HashNode> children= new HashMap<>();
        public HashNode(char value){
            this.value=value;
        }
    }
    Node root= new Node(' ');
    public void insert(String word){
        word=word.toLowerCase();
        var current=root;
        for( var ch:word.toCharArray()){
            var index= ch-'a';
            if(current.children[index]==null){
                //setting current like this helps in picking the last node to be accessed
                current= current.children[index]=new Node(ch);
            }
        }
        current.isEndOfWord=true;
    }
    HashNode hashNode= new HashNode(' ');
    public void insertHash(String word){
        word=word.toLowerCase();
        var current=hashNode;
        for(var ch: word.toCharArray()){
            if(!current.children.containsKey(ch))
            {
                var node=new HashNode(ch);
                current.children.put(ch, node);
                current =node;
            }
        }
        current.isEndOfWord=true;
    }

}
