package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BuildTreeFromInAndPreOrder {

	static class Node {
		int key;
		Node left;
		Node right;
		
		Node(int value) {
			key = value;
			left = null;
			right = null;
		}
	} 
	
	// Time O(n) space O(n) due to hash map
	static Node buildTree(int[]pre, int[] in) {
		
		int n = pre.length;
		int[] preIndex = {0};
		HashMap<Integer, Integer> inMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			inMap.put(in[i], i);
		}
		Node root = build(pre, in, inMap, preIndex, 0, (n-1));
		
		
		return root;
	}
	
	static Node build(int[]pre, int[]in, HashMap<Integer, Integer>inMap, int[]preIndex, int start, int end) {
		if (start > end) {
			return null;
		}
		Node root = new Node(pre[preIndex[0]]);
		int inIndex = inMap.get(pre[preIndex[0]]);
		preIndex[0]++;
		
		Node left = build(pre, in, inMap, preIndex, start, (inIndex -1 ));

		Node right = build(pre, in, inMap, preIndex, (inIndex+1), end);
		root.left = left;
		root.right = right;
		
	   return root;
		
	}
	
	static void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.key + " ");
	}
	
	public static void main( String[] args) {
		int[] in = {3, 1, 4, 0, 5, 2};
        int[] pre = {0, 1, 3, 4, 2, 5};
        Node root = buildTree(pre, in);
        postOrder(root);
	}
}
