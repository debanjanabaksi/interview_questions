package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class LevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree_level = new BinaryTree(); 
        tree_level.root = new Node(1); 
        tree_level.root.left = new Node(2); 
        tree_level.root.right = new Node(3); 
        tree_level.root.left.left = new Node(4); 
        tree_level.root.left.right = new Node(5); 
  
        System.out.println("Level order traversal of binary tree is - "); 
        printLevelOrder(tree_level.root);
        
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(7); 
        tree.root.left.right = new Node(6); 
        tree.root.right.left = new Node(5); 
        tree.root.right.right = new Node(4); 
        System.out.println("\nSpiral order traversal of Binary Tree is ");
        spiralTraversal(tree.root); 
        System.out.println("\nSpiral order traversal of Binary Tree is ");
        spiralTraversalStack(tree.root);

	}
	
	private static void printLevelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();

			System.out.print(" "+temp.value);
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}

		}
	}
	
	private static void spiralTraversal(Node root) {
		boolean ltr = false;
		int d = height(root);
		for (int i= 1 ; i<=d; i++) {
			printCurrentLevel(root, i, ltr);
			ltr = !ltr;
		}
	}
	
	private static void printCurrentLevel(Node node, int level, boolean ltr) {
		if (node == null) {
			return;
		}
		//System.out.println(" Node and level " + node.value+ " "+ level);
		if (level == 1) {
			System.out.print(" " + node.value);
		} else if (level > 1) {
			if (ltr) {
				printCurrentLevel(node.left, level-1 , ltr);
				printCurrentLevel(node.right, level-1 , ltr);
			} else{
				printCurrentLevel(node.right, level-1 , ltr);
				printCurrentLevel(node.left, level-1 , ltr);
			}
		}
	}
	
	private static void spiralTraversalStack(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.print(" "+temp.value);
				if(temp.right !=null) 
					s2.push(temp.right);
				if(temp.left != null)
					s2.push(temp.left);
			}
			while (!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.print(" "+temp.value);
				if(temp.left !=null) 
					s1.push(temp.left);
				if(temp.right != null)
					s1.push(temp.right);
			}
			
		}
	}

	private static int height (Node root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		if ( left > right) {
			return left+1;
		} 
			
		return right +1;
		
	}
	private static class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}
	
	private static class BinaryTree {
		Node root;
	}
}
