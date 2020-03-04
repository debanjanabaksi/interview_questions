package easy;

import java.util.Arrays;

/*
 * Given an array of an integer of size, N. Array contains N ropes of length Ropes[i].
 *  You have to perform a cut operation on ropes such that all of them are reduced by the length of the smallest rope. 
 *  Display the number of ropes left after every cut.
 *  Perform operations till the length of each rope becomes zero.
 *  Note: IF no ropes left after a single operation, in this case, we print 0.
 */
public class RopesLeftAfterRemovingSmallest {

	public static void main(String[] args) {
		int ropes[] = { 5, 1, 1, 2, 3, 5 };
		cutRopes(ropes);

	}
	
	private static void cutRopes(int[] arr) {
		int singleOperation = 0;
		int n = arr.length;
		Arrays.sort(arr);
		int currLength = arr[0];
		for(int i= 1; i < n; i++) {
			if(arr[i]-currLength > 0) {
				System.out.print(n-i + " ");
				currLength = arr[i];
				singleOperation++;
			}
		}
		if(singleOperation == 0) {
			System.out.println(0);
		}
	}

}
