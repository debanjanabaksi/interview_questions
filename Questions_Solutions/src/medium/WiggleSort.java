package medium;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3].... Try O(n) time and /or O(1) space
 * 
 * 
 *
 */
public class WiggleSort {

	public static void main(String[] args) {
		int arr[] = { 10, 5, 6, 3, 2, 20, 100, 80 };
		int[] nums = {1, 5, 1, 1, 6, 4};
		int[] a = {1, 3, 2, 2, 3, 1};
		WiggleSort w = new WiggleSort();
		w.wiggleSort(arr);
		w.wiggleSort(nums);
		w.wiggleSort(a);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		for (int i = 0; i < nums.length; i++) {
			System.out.print(" " + nums[i]);
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
	}

	private void wiggleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (i % 2 != 0) {
				if (i > 0 && arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
				}
				if (i < n - 1 && arr[i] < arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
