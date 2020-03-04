package medium;
/*
 * Given an array with n objects colored red, white or blue, 
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	Input: [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
	Also known as the Dutch flag problem
 */

public class SortColours {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		sortColours(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int arr2[] = {1,1, 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 2 };
		sortColours(arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

	private static void sortColours(int[] arr) {
		int n = arr.length;
		int low = 0, mid = 0, high = n - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				//prevent unnecessary swaps
				if (arr[mid] != arr[low]) {
					int temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
				}
				low++;
				mid++;
			} else if (arr[mid] == 2) {
				if (arr[mid] != arr[high]) {
					int temp = arr[high];
					arr[high] = arr[mid];
					arr[mid] = temp;
				}
				high--;

			} else {
				mid++;
			}
		}
		
	}

}
