package com.balazsholczer.redblacktree;

public class App {

    public static void main(String[] args) {

    	RedBlackTree tree = new RedBlackTree();
       
        tree.insert(10);
        tree.traverseGraph();
        tree.insert(20);
        tree.traverseGraph();
        tree.insert(30);
        tree.traverseGraph();
        tree.insert(15);
      
        tree.traverseGraph();
    }
}
