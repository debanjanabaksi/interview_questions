package medium;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(6); 
        tree.root.left = new Node(3); 
        tree.root.right = new Node(5); 
        tree.root.right.right = new Node(4); 
        tree.root.left.left = new Node(2); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.right = new Node(4); 
        tree.root.left.right.left = new Node(7); 
           
        System.out.print("Sum of all paths is " +  
        		sumOfPaths(tree.root));  
	}
	
	private static int sumRootToLeaf(Node root, int val) {
		if(root == null) {
			System.out.println("Null root");
			return 0;
		}
		System.out.println("init val : "+val);
		val = val*10 + root.value; // number formed upto this node
		
		System.out.println("current val : "+val);
		
		//If current node is leaf, return val upto this node. Stop recursion
		//else when leaf nodes are reached, their children will be null and return 0.
		//so sum = left+ right = 0. final result will be 0;
		if(root.left == null && root.right == null) {
			return val;
		}
		
		int leftVal = sumRootToLeaf(root.left, val);// num formed by left path
		int rightVal = sumRootToLeaf(root.right, val);// num formed by right path
		
		System.out.println("left val : "+leftVal);
		System.out.println("right val : "+rightVal);
		
		int sum = leftVal+rightVal;
		
		System.out.println("left val + right val : "+sum);
		
		
		return sum;// sum of nums in the paths
	}
	
	private static int sumOfPaths(Node node) {
		return sumRootToLeaf(node, 0);
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
