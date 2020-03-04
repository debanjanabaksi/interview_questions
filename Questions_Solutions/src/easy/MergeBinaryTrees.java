package easy;


/**
 * 
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other,
 *  some nodes of the two trees are overlapped while the others are not.
 *  The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
 *  Otherwise, the NOT null node will be used as the node of new tree.
 *  Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 *
 */
public class MergeBinaryTrees {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeBinaryTrees mergeTrees = new MergeBinaryTrees();
		
		//Tree1
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);
		root.left.left = new Node(5);
		
		//Tree2
		Node root2 = new Node(2);
		root2.left = new Node(1);
		root2.right = new Node(3);
		root2.left.right = new Node(4);
		root2.right.right = new Node(7);	
		
		Node root1 = merge(root, root2);
		System.out.println();
		traverse(root1);
		
	}
	
	private static Node merge(Node t1, Node t2) {
		if (t1 == null) {
			return t2;
		} 
		if (t2 == null) {
			return t1;
		}
		t1.value = t1.value + t2.value;
		t1.left = merge(t1.left, t2.left);
		t1.right = merge(t1.right, t2.right);
		return t1;
	}
	private static class Node {
		int value;
		Node left, right;
		Node(int value) {
			this.value = value;
		}

	}
	
	private static void traverse(Node root) {
		if(root == null) {
			return;
		}
		traverse(root.left);
		System.out.print(" "+root.value);
		traverse(root.right);
	}

}