package trees;



public class MaxPathSumInBinaryTree {
	
	// We will go bottom up. It is based on post order traversal. We will find the value of max sum path at left and right sub tree first.
	// Then sum at current root i.e. maxleft + maxright + root. If thats more than global max , it will be new max
	// We also need to return the value of the max sum path through the node. Since we want a path, it has to be in a line, so we will take root + either left or right path
	// We choose max of left and right and add to node and return
	
	public static void main(String[] args) {
		
		Result res = new Result();
		res.max = Integer.MIN_VALUE;
		
		 Node root = new Node(10);
	     root.left = new Node(2);
	     root.right = new Node(-25);
         root.left.left = new Node(20);
	     root.left.right = new Node(1);
	     root.right.left = new Node(3);
         root.right.right = new Node(4);
         
         MaxPathSumInBinaryTree ms = new MaxPathSumInBinaryTree();
         System.out.println("The max path sum is "+ ms.findMax(root, res));
         
         
         Node root2 = new Node(1);
         root2.left = new Node(2);
         root2.right = new Node(3);
         root2.left.left = new Node(4);
         root2.left.right = new Node(5);
         root2.left.right.right = new Node(6);
         root2.left.right.right.right = new Node(7);

 		 res.max = Integer.MIN_VALUE;
         System.out.println("The max path sum is "+ ms.findMax(root2, res));
         
         Node root3 = new Node(10);
         root3.left = new Node(2);
         root3.right = new Node(10);
         root3.left.left = new Node(20);
         root3.left.right = new Node(1);
         root3.right.right = new Node(-25);
         root3.right.right.left = new Node(3);
         root3.right.right.right = new Node(4);
         
 		 res.max = Integer.MIN_VALUE;
         System.out.println("The max path sum is "+ ms.findMax(root3, res));
         
         
	}
	
	int findMax(Node root, Result res) {
		findMaxSum(root, res);
		return res.max;
	}
	
	// This calculates the max at every step and also returns the value of max sum path at each step
	// uses the max of left and right subtree tree and current node to determine the path
	// Time O(n) space O(h)
	int findMaxSum(Node root, Result res) {
		
		if ( root == null ) {
			return 0;
		}
		int left = findMaxSum(root.left, res);
		int right = findMaxSum(root.right, res);
		
		int leftSum = Math.max(0, left);
		int rightSum = Math.max(0, right);
		
		res.max = Math.max(res.max, rightSum + leftSum + root.value);
		
		// Considering the root to be the parent of the subtree with max sum.The path needs to be in a straight line so either left or right subtree can be included here.
		 
	
		return Math.max(leftSum, rightSum)+ root.value;
	}
	 
	
}
class Node {
	public int value;
	public Node left, right;
	
	public Node(int val) {
		this.value = val;
		left = null;
		right = null;
	}
}
 
 class Result {
	 int max;
 }