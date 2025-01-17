package trees;


public class CheckTreeSymmetry {

	public static void main(String[] args) {

		/* Construct below tree
        1
      /   \
     /     \
    2       3
     \     /
      5   6
  */

	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.right = new Node(4);
	root.right.left = new Node(5);

	if (isSymmetric(root)) {
		System.out.print("Yes");
	} else {
		System.out.print("No");
	}

}

	private static class Node {
		public int value;
		public Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}

	private static boolean isSymmetric(Node root) {
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(Node x, Node y) {
		if (x == null && y == null) {
			return true;
		}
		return ((x != null && y != null) && (isSymmetric(x.left, y.right) && isSymmetric(x.right, y.left)));
	}

}
