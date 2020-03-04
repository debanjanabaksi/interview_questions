package trees;
//Truncate binary tree to remove nodes which lie on a path having sum less than k


public class RemoveNodesInPathWithLessSum {

	public static void main(String[] args) {
		 /* Construct below tree
        6
      /   \
     /     \
    3       8
          /   \
         /     \
        4          2
      /   \      \
     /     \      \
    1       7      3
*/

Node root = new Node(6);
root.left = new Node(3);
root.right = new Node(8);
root.right.left = new Node(4);
root.right.right = new Node(2);
root.right.left.left = new Node(1);
root.right.left.right = new Node(7);
root.right.right.right  = new Node(3);
System.out.println("Tree before truncation :");
inorder(root);
int k = 20;
root = truncateTree(root, k);
System.out.println("\nTree after truncation :");
inorder(root);

	}
	
	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
	private static void inorder(Node root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}
	
	private static Node truncate(Node root, int sum, int k) {
		if (root == null) {
			return null;
		}
		sum = sum + root.value;
		
		root.left = truncate(root.left, sum, k);
		root.right = truncate(root.right, sum, k);
		//can move it to a method isLeaf
		if((root.left==null && root.right == null) && sum <k) {
			return null;
		}
		
		return root;
		
	}
	
	private static Node truncateTree(Node root, int k) {
		int sum = 0;
		root = truncate(root, 0, k);
		return root;
	}


}
