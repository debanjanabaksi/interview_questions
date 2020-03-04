package easy;


public class DepthOfBinaryTree {
	
	//If there are n nodes in binary tree, maximum height of the binary tree is n-1 
	//and minimum height is floor(log2n)???(nt v sure). If the tree is skewed it may have a height of n-1, if balanced floor(log2n)
	//So program to be generic to calculate height
	
	public static void main(String args[]) {
		DepthOfBinaryTree depth = new DepthOfBinaryTree();
		BinaryTree tree1 = depth.new BinaryTree();
		BinaryTree tree2 = depth.new BinaryTree();
		tree1.root =  depth.new Node(1);
		tree1.root.left = depth.new Node(2);
		tree1.root.right = depth.new Node(3);
		tree1.root.left.left = depth.new Node(4);
		tree1.root.left.right = depth.new Node(5);
		
		// skewed tree
		tree2.root =  depth.new Node(1);
		tree2.root.left = depth.new Node(2);
		tree2.root.left.left = depth.new Node(3);
		tree2.root.left.left.left = depth.new Node(4);
		tree2.root.left.left.left.left = depth.new Node(5);
		
		//Find height by program
		
		System.out.println("Height of first tree is : "+ tree1.maxHeight(tree1.root));
		System.out.println("Height of second tree is : "+ tree2.maxHeight(tree2.root));
		
	}
	
	private class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	} 
	
	private class BinaryTree {
		Node root;
		
		int maxHeight(Node root) {
			
			if (root == null) {
				return 0;
			}
			
			return Math.max(maxHeight(root.left), maxHeight(root.right))+1;
		}
	}

}
