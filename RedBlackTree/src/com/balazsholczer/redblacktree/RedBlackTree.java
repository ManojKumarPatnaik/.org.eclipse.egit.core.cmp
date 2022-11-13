package com.balazsholczer.redblacktree;

public class RedBlackTree {

	private Node root;

	public void traverseGraph() {
		if (this.root != null) {
			traverseInOrder(root);
		}
	}
	
	public void insert(int newData) {
		
		Node node = new Node(newData);
		root = insertIntoTree(root, node);
		
		fixViolations(node);
	}

	private Node insertIntoTree(Node root, Node node) {
		
		if( root == null ) return node;
		
		if( node.getData() < root.getData() ) {
			root.setLeftChild( insertIntoTree(root.getLeftChild(), node));
			root.getLeftChild().setParent(root);
		} else if ( node.getData() > root.getData() ) {
			root.setRightChild( insertIntoTree(root.getRightChild(), node ));
			root.getRightChild().setParent(root);
		}
		
		return root;
	}

	private void fixViolations(Node node) {
		
		Node parentNode = null;
		Node grandParentNode = null;
		
		while( node != root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED ) {
			
			parentNode = node.getParent();
			grandParentNode = node.getParent().getParent();
			
			if( parentNode == grandParentNode.getLeftChild() ) {
				
				Node uncle = grandParentNode.getRightChild();
				
				// given node x's parent is a left child + uncle is red --> only recoloring
				if( uncle != null && uncle.getColor() == NodeColor.RED ) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode; // this will be the x after the recoloring because we have to check whether
					// the properties are violated or not
				} else {
					
					if( node == parentNode.getRightChild() ) {
						leftRotate(parentNode);
						node = parentNode;
						parentNode = node.getParent();
					}
					
					rightRotate(grandParentNode);
					System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;
				}
			} else {
				
				Node uncle = grandParentNode.getLeftChild();
				
				if( uncle != null && uncle.getColor() == NodeColor.RED ) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode; 
				} else {
					
					if( node == parentNode.getLeftChild()) {
						rightRotate(parentNode);
						node = parentNode;
						parentNode = node.getParent();
					}
					leftRotate(grandParentNode);
					System.out.println("Recoroling "+parentNode+" + "+grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;
				}
			}
		}
		
		if( root.getColor() == NodeColor.RED ) {
			System.out.println("Recoloring the root to black...");
			root.setColor(NodeColor.BLACK);
		}
	}

	private void rightRotate(Node node) { // az input a beszurt node grandparentje
		System.out.println("Rotate right on node " + node);
		Node tempLeftNode = node.getLeftChild();
		node.setLeftChild(tempLeftNode.getRightChild());
		
		if( node.getLeftChild() != null )
			node.getLeftChild().setParent(node);
		
		tempLeftNode.setParent(node.getParent());
		
		if( tempLeftNode.getParent() == null )
			root = tempLeftNode;
		else if( node == node.getParent().getLeftChild() )
			node.getParent().setLeftChild(tempLeftNode);
		else
			node.getParent().setRightChild(tempLeftNode);
		
		tempLeftNode.setRightChild(node);
		node.setParent(tempLeftNode);
	}

	private void leftRotate(Node node) { // az input a beszurt node grandparentje
		System.out.println("Rotate left on node " + node);
		Node tempRightNode = node.getRightChild();
		node.setRightChild(tempRightNode.getLeftChild());
		
		if( node.getRightChild() != null )
			node.getRightChild().setParent(node);
		
		tempRightNode.setParent(node.getParent());
		
		if( tempRightNode.getParent() == null )
			root = tempRightNode;
		else if( node == node.getParent().getLeftChild() )
			node.getParent().setLeftChild(tempRightNode);
		else
			node.getParent().setRightChild(tempRightNode);
		
		tempRightNode.setLeftChild(node);
		node.setParent(tempRightNode);
	}

	private void traverseInOrder(Node node) {

		if (node.getLeftChild() != null) {
			traverseInOrder(node.getLeftChild());
		}

		System.out.println(node + " with color: " + node.getColor()+" LeftNode: "+node.getLeftChild()+" - RightNode: "+node.getRightChild());

		if (node.getRightChild() != null) {
			traverseInOrder(node.getRightChild());
		}
	}
}
