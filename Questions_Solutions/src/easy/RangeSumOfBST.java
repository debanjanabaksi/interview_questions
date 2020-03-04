package easy;

import easy.BinarySearchTreeHelper;

/**
 * Range Sum of BST Given the root node of a binary search tree, return the sum
 * of values of all nodes with value between L and R (inclusive).
 * 
 * 
 *
 */
public class RangeSumOfBST {
	// Input: root = [10,5,15,3,7,0,18], L = 7, R = 15
	// Output: 32

	// Input: root = [10,5,15,3,7,13,18,1,0,6], L = 6, R = 10
	// Output: 23
	public static void main(String args[]) {
		BinarySearchTreeHelper bst = new BinarySearchTreeHelper();
		int[] tree = { 10, 5, 15, 3, 7, 0, 18 };
		BinarySearchTreeHelper.Node root = bst.createTree(tree);

		bst.traverseInOrder(root);

		int sum = rangeSum(root, 7, 15);
		System.out.println(" Sum is : " + sum);
		System.out.println(" Find count");
		int count = getCountInRange(root, 7, 15);
		System.out.println("Count is : " + count);

	}

	private static int getCountInRange(BinarySearchTreeHelper.Node root, int left, int right) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		System.out.println("\nTraveresed Number  is : " + root.value);
		if (root.value >= left && root.value <= right) {
			System.out.println("\nNumber  is : " + root.value);
			count = 1 + getCountInRange(root.left, left, right) + getCountInRange(root.right, left, right);
		} else if (root.value < left) {
			return getCountInRange(root.right, left, right);
		} else {
			return getCountInRange(root.left, left, right);
		}
		return count;
	}

	private static int rangeSum(BinarySearchTreeHelper.Node root, int left, int right) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		System.out.print("\nNumber  is : " + root.value);
		if (root.value >= left && root.value <= right) {
			System.out.println(" Adding");
			sum = root.value + rangeSum(root.left, left, right) + rangeSum(root.right, left, right);
		} else if (root.value < left) {
			return rangeSum(root.right, left, right);
		} else {
			return rangeSum(root.left, left, right);
		}
//			System.out.println("Value is "+root.value+" sum is "+ sum);
//			System.out.println("Left is "+left);
//			System.out.println("Right value  "+right);
		return sum;
	}

}
