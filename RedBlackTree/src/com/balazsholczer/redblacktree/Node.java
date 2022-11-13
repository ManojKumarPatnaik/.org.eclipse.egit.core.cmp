package com.balazsholczer.redblacktree;

public class Node {

	private int data;
	private NodeColor color;
	private Node leftChild;
	private Node rightChild;
	private Node parent;

	public Node(int data) {
		this.data = data;
		this.color = NodeColor.RED;
	}

	public int getData() {
		return data;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public NodeColor getColor() {
		return color;
	}

	public void setColor(NodeColor color) {
		this.color = color;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setData(int data) {
		this.data = data;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return ""+this.data;
	}
}
