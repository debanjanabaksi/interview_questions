package trees;

/**
 * Find the number of BST for given number of nodes
 * 
 *
 */
public class EnumerationOfBinaryTrees {

	public static void main(String[] args) {

		int n = 3;
		int n2 = 4;
		int n3 = 5;
		System.out.println("Number of possible trees with " + n + " nodes is " + count(n));
		System.out.println("Number of possible trees with " + n2 + " nodes is " + count(n2));
		System.out.println("Number of possible trees with " + n3 + " nodes is " + count(n3));
	}

	private static int count(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + count(i - 1) * count(n - i);
		}
		return sum;
	}

}
