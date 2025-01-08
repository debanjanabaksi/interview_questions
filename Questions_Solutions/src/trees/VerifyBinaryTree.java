package trees;
// Create a sample binary tree
//      4
//    /   \
//   2     5
//  / \
// 1   3

public class VerifyBinaryTree {

	private static class Node {
		public int value;
		public Node left, right;
		
		public Node(int val) {
			this.value = val;
			left = null;
			right = null;
		}
	}
	
	// Time is O(n) space is O(h) where h is height of bst
	private static boolean isValidBinarySearchTreeInorder(Node root, int[] prev) {
		if (root == null)
			return true;
		
		if (!isValidBinarySearchTreeInorder(root.left, prev))
				return false;
		if( prev[0] >= root.value)
			return false;
		prev[0] = root.value;
		
		return isValidBinarySearchTreeInorder(root.right, prev);
	}
	
	// Traversal strategy : LNR
	// Time O(n) Space O(1)
	private static boolean isValidMorrisTraversal(Node root) {
		
		Node curr = root;
		Node pre;
		int preVal = Integer.MIN_VALUE;
		
		while (curr != null) {
			
			if (curr.left == null) {
				if (curr.value <= preVal)
						return false;
				preVal = curr.value;
				curr = curr.right;
				
			}
			else {
				pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left; //here we are only finding the inorder predecessor , and then starting traversal by going left, its not yet 
									  //time to visit root node. so we are not setting the preVal.
				}
				else {
					pre.right = null;
					if (curr.value <= preVal) {
						return false;
					}
					preVal = curr.value; // Here we are visiting the root since left subtree is over. Hence comparing and also setting preVal.
					curr = curr.right;
				}
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		//root.left.right.right = new Node(7);
		int[] prev = {Integer.MIN_VALUE};
		
		if (isValidBinarySearchTreeInorder(root, prev)) {
			System.out.println("This is a Binary Search Tree");
		}
		
		else {
			System.out.println("This is not a Binary Search Tree");
		}
		
		if (isValidMorrisTraversal(root)) {
			System.out.println("This is a Binary Search Tree (Morris traversal method)");
		}
		
		else {
			System.out.println("This is not a Binary Search Tree (Morris traversal method)");
		}
	}
}
