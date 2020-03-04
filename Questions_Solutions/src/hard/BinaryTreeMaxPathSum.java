package hard;


public class BinaryTreeMaxPathSum {

	public static void main(String[] args) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(20); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        
        findMaxSum(tree.root, max);
        
        System.out.println("Max path sum is : "+ max[0]);

	}
	
	private static int findMaxSum(Node root, int[] max) {
		if(root == null) {
			return 0;
		}
		
		int leftMax = findMaxSum(root.left, max);
		int rightMax = findMaxSum(root.right, max);
		
		int currMax = Math.max(root.value, Math.max(leftMax, rightMax)+root.value);
		int maxTop = Math.max(currMax, (leftMax+root.value+rightMax));
		max[0] = Math.max(max[0], maxTop);
		 System.out.println("Max path sum is : "+ max[0]);
		return currMax;
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
