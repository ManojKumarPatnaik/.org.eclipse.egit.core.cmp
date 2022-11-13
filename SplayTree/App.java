package SplayTree;

public class App {

	
	
	public static void main(String[] args) {
		
		Tree<Integer> splayTree = new SplayTree<>();
		
		splayTree.insert(10);
		splayTree.insert(0);
		splayTree.insert(234);
		splayTree.insert(-3);
		splayTree.insert(23);
		splayTree.insert(-56);
		splayTree.insert(78);
		
		splayTree.inOrderTraversal();
		
	}
}
