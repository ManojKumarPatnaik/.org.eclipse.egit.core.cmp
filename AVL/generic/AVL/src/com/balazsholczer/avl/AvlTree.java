package com.balazsholczer.avl;


public class AvlTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		root = insert(root, data);
	}

	@Override
	public void delete(T data) {
		root = delete(root, data);
	}

	private Node<T> insert(Node<T> node, T data) {

		if (node == null) {
			return new Node<T>(data);
		}

		if (data.compareTo(node.getData()) < 0 ) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else {
			node.setRightNode(insert(node.getRightNode(), data));
		}

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		return settleViolation(data, node);
	}


	private Node<T> delete(Node<T> node, T data) {

		if (node == null)
			return node;

		// first we have to look for the node we want to get rid of
		if (data.compareTo(node.getData()) < 0 ) {  // data smaller than given node's data -> go to the left recursively
			node.setLeftNode(delete(node.getLeftNode(), data));
		} else if (data.compareTo(node.getData()) > 0 ) { // data greater than given node's data -> go to the right recursively
			node.setRightNode(delete(node.getRightNode(), data));
		} else {  // we have found the node we want to remove !!!

			if (node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Removing a leaf node...");
				return null;
			}

			if (node.getLeftNode() == null) {
				System.out.println("Removing the right child...");
				Node<T> tempNode = node.getRightNode();
				node = null;
				return tempNode;
			} else if (node.getRightNode() == null) {
				System.out.println("Removing the left child...");
				Node<T> tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			}

			// this is the node with two children case !!!
			System.out.println("Removing item with two children...");
			Node<T> tempNode = getPredecessor(node.getLeftNode());

			node.setData(tempNode.getData());
			node.setLeftNode(delete(node.getLeftNode(), tempNode.getData()));
		}

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		// have to check on every delete operation whether the tree has become unbalanced or not !!!
		return settleDeletion(node);
	}

	private Node<T> settleDeletion(Node<T> node) {
		
		int balance = getBalance(node);

		// OK, we know the tree is left heavy BUT it can be left-right heavy or left-left heavy
		if (balance > 1) {
			
			// left right heavy situation: left rotation on parent + right rotation on grandparent
			if (getBalance(node.getLeftNode()) < 0) {
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}

			// this is the right rotation on grandparent ( if left-left heavy, thats single right rotation is needed
			return rightRotation(node);
		}

		// OK, we know the tree is right heavy BUT it can be left-right heavy or right-right heavy
		if (balance < -1) {
			// right - left heavy so we need a right rotation ( on parent!!! ) before left rotation
			if (getBalance(node.getRightNode()) > 0) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}

			// left rotation on grand parent
			return leftRotation(node);
		}

		return node;
	}

	private Node<T> getPredecessor(Node<T> node) {

		Node<T> predecessor = node;

		while (predecessor.getRightNode() != null)
			predecessor = predecessor.getRightNode();

		return predecessor;
	}

	private Node<T> settleViolation(T data, Node<T> node) {

		int balance = getBalance(node);

		// this is the Case I !!!! left-left
		if (balance > 1 && data.compareTo(node.getLeftNode().getData()) < 0 ) {
			System.out.println("Tree is left left heavy...");
			return rightRotation(node);
		}

		// this is the Case II right-right !!!!
		if (balance < -1 && data.compareTo(node.getRightNode().getData()) > 0 ) {
			System.out.println("Tree is right right heavy...");
			return leftRotation(node);
		}

		// left right situation
		if (balance > 1 && data.compareTo(node.getLeftNode().getData()) > 0) {
			System.out.println("Tree is left right heavy...");
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}

		// right left situation
		if (balance < -1 && data.compareTo(node.getRightNode().getData()) < 0) {
			System.out.println("Tree is right left heavy...");
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}

		return node;
	}

	private Node<T> rightRotation(Node<T> node) {

		System.out.println("Rotating to the right on node: " + node);

		Node<T> tempLeftNode = node.getLeftNode();
		Node<T> t = tempLeftNode.getRightNode();

		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

		return tempLeftNode;
	}

	private Node<T> leftRotation(Node<T> node) {

		System.out.println("Rotating to the left on node:" + node);

		Node<T> tempRightNode = node.getRightNode();
		Node<T> t = tempRightNode.getLeftNode();

		tempRightNode.setLeftNode(node);
		node.setRightNode(t);

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempRightNode
				.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

		return tempRightNode;
	}

	private int height(Node<T> node) {

		if (node == null) {
			return -1;
		}

		return node.getHeight();
	}

	private int getBalance(Node<T> node) {

		if (node == null) {
			return 0;
		}

		return height(node.getLeftNode()) - height(node.getRightNode());
	}

	public void traverse() {

		if (root == null)
			return;

		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node<T> node) {

		if (node.getLeftNode() != null)
			inOrderTraversal(node.getLeftNode());

		System.out.println(node);

		if (node.getRightNode() != null)
			inOrderTraversal(node.getRightNode());
	}
}
