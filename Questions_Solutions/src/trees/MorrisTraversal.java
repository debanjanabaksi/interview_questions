package trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {

	// This is based on Threaded Binary Trees where the leaf node , in this case the right most node of a subtree holds a link ( thread ) back to its predecessor 
	// Since it doesn't have any children, a child link is created temporarily to link back to its predecessor in the traversal.
	// This allows traversal back up the tree without a stack ( explicit data structure or recursion stack ) This allows for an O(n) time complexity and O(1) space complexity
	// If one stores the traversed nodes then it becomes O(n) for space too, but thats optional totally and not due to the algo itself.
	public static void main(String[] args) {
		 // Representation of input binary tree:
        //           1
        //          / \
        //         2   3
        //            / \  
        //           4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        
        List<Integer> result = inOrder(root);
        for(int val : result) {
        	System.out.print(val + " ");
        }
        List<Integer> result2 = preOrder(root);
        System.out.println();
        for (int data : result2) {
        	System.out.print(data + " ");
        }
	}
	
	static class Node {
	  int value;
	  Node left = null; 
	  Node right = null;
	  
	  Node(int val) {
		  value = val;
	  }
	}
	
	private static List<Integer> inOrder(Node root) {
		List<Integer> traversal = new ArrayList<Integer>();
		
		Node curr = root;
		
		while (curr != null) {
			// If there is no left subtree, add curr to ans and visit the right
			if (curr.left == null) {
				traversal.add(curr.value);
				curr = curr.right;
			} else {
				// Find the in order predecessor . That is the rightmost node of the left subtree
				Node prev = curr.left;
				// Visit the right child(subtree) of left subtree. 
				// Rightmost will have no more children. Or it will have thread back to parent node.
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if (prev.right == null) {// Found rightmost node,link it back to in order predecessor and proceed with actual in order traversal so traverse left child of curr
					prev.right = curr;
					curr = curr.left;
				}
				else if (prev.right == curr) { // The left subtree has already been traversed
					prev.right = null; // Remove the link, not needed anymore
					traversal.add(curr.value);
					curr = curr.right; // Proceed with traversal and go to right subtree now.
				}
			}
		}
		return traversal;
		
	}
	
	private static List<Integer> preOrder(Node root) {
		List<Integer> traversal = new ArrayList<Integer>();
		
		Node curr = root;
		
		while (curr != null) {
			if (curr.left == null) {
				traversal.add(curr.value);
				curr = curr.right;
			}
			else {
				Node prev = curr.left;
				
				while (prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				
				if (prev.right == null) {
					prev.right = curr;
					traversal.add(curr.value);
					curr = curr.left;
				}
				else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		return traversal;
		
	}
	
	// Check this out
	// https://www.geeksforgeeks.org/kth-smallest-element-in-bst-using-o1-extra-space/

	
}
