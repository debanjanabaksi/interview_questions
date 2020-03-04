package trees;

import trees.BinarySearchTreeHelper.Node;

public class FindSecondMaxNodeInBST {

	static int count = 0;
	public static void main(String[] args) {
		BinarySearchTreeHelper bst = new BinarySearchTreeHelper();
		int[] tree = {50,30,20,40,70,60,80};
		Node root = bst.createTree(tree);
		findSecondMax(root);

	}

	private static void findSecondMax(Node root) {
		if(root == null || count >=2) {
			return;
		}
		findSecondMax(root.right);
		count++;
		if(count == 2) {
			System.out.println("Second largest value is "+ root.value);
			return;
		}
		findSecondMax(root.left);
	}
}
