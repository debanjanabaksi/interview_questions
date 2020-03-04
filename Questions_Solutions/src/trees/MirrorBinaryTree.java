package trees;

public class MirrorBinaryTree {

	public static void main(String[] args) {
		 /* Construct below tree
        1
      /   \
     /     \
    2       3
   / \     / \
  4   5   6   7   */

	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.right.left = new Node(6);
	root.right.right = new Node(7);

	MirrorBinaryTree mirror = new MirrorBinaryTree();
	mirror.preorder(root);
	mirror.mirror(root);
	System.out.println("\nMirrored tree is ");
	mirror.preorder(root);

	}
	
	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}
	
	private  void mirror(Node root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);
		swap(root);
	}
	private  void swap(Node root) {
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	private  void preorder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(" " +root.value);
		preorder(root.left);
		preorder(root.right);
	}

}
