package easy;

public class BinarySearchTreeHelper {

	public class Node {
		public int value;
		public Node left, right;
		public Node(int value) {
			this.value = value;
		}
	}

	public Node createTree(int[] values) {
		Node root = null;
		for (int value : values) {
			root = insert(root, value);
		}
		return root;
	}

	private Node insert(Node root, int val) {
		System.out.println("Inserting "+val);
		if (root == null) {
			//System.out.print(" Creating new root ");
			root = new Node(val);
		} else if (val < root.value) { 
			//System.out.print(" "+root.value+" is greater creating left sub tree");
			root.left = insert(root.left, val);
		} else {
			//System.out.print(" "+root.value+" is lesser creating right sub tree");
			root.right = insert(root.right, val);
		}
		System.out.println();
		return root;
	}

	public void traverseInOrder(Node root) {
		if (root == null) {
			return;
		}
		traverseInOrder(root.left);
		System.out.print(" " + root.value);
		traverseInOrder(root.right);
	}
}
