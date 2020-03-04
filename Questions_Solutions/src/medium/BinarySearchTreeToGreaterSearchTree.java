package medium;

import easy.BinarySearchTreeHelper;
import easy.BinarySearchTreeHelper.Node;

/*
 * Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */

public class BinarySearchTreeToGreaterSearchTree {

	static int sum =0;
	public static void main(String[] args) {
		int[] tree = { 4, 1, 6, 0, 2, 5, 7, 3, 8 };
		BinarySearchTreeHelper bst = new BinarySearchTreeHelper();
		Node root = bst.createTree(tree);
		bst.traverseInOrder(root);
		System.out.println("");
		bstToGst(root);
		System.out.println("New Tree");
		bst.traverseInOrder(root);
	}

	//Solution 1, keep external variable. in place but space complexity is O(n)? we traverse each node? time also O(n);
	private static void bstToGst(Node root) {
		if (root == null) {
			return;
		}
		System.out.println("Inside bstToGst root value and sum is : "+ root.value+ " "+ sum);
		bstToGst(root.right);
		sum = sum + root.value;
		System.out.println("Inside bstToGst root value and old and new are : "+ root.value+ " "+ sum);
		root.value = sum;
		bstToGst(root.left);
	}
}
