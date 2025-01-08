package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//input nodes
/*
	         1
	      /  |  \
	     /   |   \
	    2    3    4
	   / \      / | \
	  /   \    7  8  9
	 5     6
	/    / | \
  10   11 12 13
*/

public class N_AryPreOrderTraversal {

	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));
 
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.get(0).children.add(
            new Node(10));
        root.children.get(0).children.add(new Node(6));
        root.children.get(0).children.get(1).children.add(
            new Node(11));
        root.children.get(0).children.get(1).children.add(
            new Node(12));
        root.children.get(0).children.get(1).children.add(
            new Node(13));
        root.children.get(2).children.add(new Node(7));
        root.children.get(2).children.add(new Node(8));
        root.children.get(2).children.add(new Node(9));
        
        preOrder(root);

	}
	
	static class Node {
		int key;
		List<Node> children ;
		
		Node(int value) {
			key = value;
			children = new ArrayList<Node>();
		}
	}
	
	// Time O(n) Space O(h)
	static void preOrder(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> nodes = new Stack<Node>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		nodes.add(root);
		while (!nodes.isEmpty()) {
			Node current = nodes.pop();
			visited.add(current.key); // NLR traversal
			List<Node> children = current.children;
			for(int i = children.size()-1 ; i >= 0; i--) {
				nodes.add(children.get(i)); // Since we are using stack, if we go from left to right, pop will be right to left and order incorrect.
			}
		}
		
		for(int val : visited) {
			System.out.print(val+ " ");
		}
	}
}
