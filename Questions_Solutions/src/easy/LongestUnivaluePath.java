package easy;


public class LongestUnivaluePath {
	static int maxDepth = -1;
	
	public static void main(String[] args) {
 /* Let us construct a Binary Tree 
         4 
     	/ \ 
       4  4 
    	/ \ \ 
    	4 9 5 */
		Node root = null; 
		root = new Node(4); 
		root.left = new Node(4); 
		root.right = new Node(4); 
		root.left.left = new Node(4); 
		root.left.right = new Node(9); 
		root.right.right = new Node(5); 
		System.out.print(longestUnivaluePath(root, 4)); 
	}
	
	private static int longestUnivaluePath(Node root, int parentVal) {
		if (root == null) {
			return 0;
		}
		int left = longestUnivaluePath(root.left, root.value);
		int right = longestUnivaluePath(root.right, root.value);
		//since depth is calculated by num of edges between nodes, we need to add edges from both sides
		maxDepth = Math.max(maxDepth, right+left);
		if(root.value != parentVal) {
			return 0;
		}
		// the method returns the longest uni value path and not depth. so max path length will be max of either child+1. But depth will 
		// add the edges.
		return Math.max(left, right)+1;
	}
	private static class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}

	private static class BinaryTree{
		Node root;
	}

}

