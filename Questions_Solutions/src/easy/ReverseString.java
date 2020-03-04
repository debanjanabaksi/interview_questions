package easy;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory. You may assume all the
 * characters consist of printable ascii characters.
 * 
 * @author debanjana_baksi
 *
 */

public class ReverseString {

	public static void main(String args[]) {
		char[] arr1 = { 'h', 'e', 'l', 'l', 'o' };
		char arr2[] = { 'M', 'o', 'n', 'd', 'a', 'y' };
		ReverseString rs = new ReverseString();
		rs.reverseUsingPointer(arr1);
		System.out.println();
		rs.reverseUsingPointer(arr2);
		System.out.println("\nWhile loop");
		rs.reverseUsingPointerWhileLoop(arr1);
		System.out.println();
		rs.reverseUsingPointerWhileLoop(arr2);
		System.out.println("\nRecursion");
		rs.reverseUsingRecursion(arr1, 0, arr1.length - 1);
		System.out.println();
		rs.printArray(arr1);
		rs.reverseUsingRecursion(arr2, 0, arr2.length - 1);
		System.out.println();
		rs.printArray(arr2);

	}

	// Using pointers O(n) time O(1) space
	private void reverseUsingPointer(char[] arr) {
		for (int i = 0; i < (arr.length) / 2; i++) {
			swap(arr, i, (arr.length - 1) - i);
		}
		printArray(arr);

	}

	// Using pointers O(n) time O(1) space
	private void reverseUsingPointerWhileLoop(char[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
		printArray(arr);
	}

	// Using recursion O(n) time O(n ) space complexity due to recursion stack but
	// still in place
	private void reverseUsingRecursion(char[] arr, int left, int right) {
		// System.out.println("left , right, elements"+ left+" "+right+" "+arr[left]+"
		// "+arr[right]);
		if (left >= right) {
			return;
		}
		swap(arr, left, right);
		reverseUsingRecursion(arr, ++left, --right);
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void printArray(char[] arr) {
		for (char element : arr) {
			System.out.print(" " + element);
		}
	}
}
