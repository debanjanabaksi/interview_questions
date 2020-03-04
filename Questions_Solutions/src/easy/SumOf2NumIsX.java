package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 *
 */
public class SumOf2NumIsX {

	public static void main (String args[]) {
		int arr[] = {1,2,5,6,7,9,11};
		int x = 21;
		SumOf2NumIsX s = new SumOf2NumIsX();
		int ans [] = s.bruteForce(arr, x);
		if (ans == null) {
			System.out.println("No numbers of sum "+x+ " found");
		} else {
			System.out.println("Numbers of sum "+x+ " found at"+ ans[0]+" "+ ans[1]);
			System.out.println("Numbers of sum "+x+ " are "+ arr[ans[0]]+" "+ arr[ans[1]]);
		}
		int ans2[]  = s.findNums(arr, x);
		if (ans2 == null) {
			System.out.println("No numbers of sum "+x+ " found");
		} else {
			System.out.println("Numbers of sum "+x+ " found at"+ ans2[0]+" "+ ans2[1]);
			System.out.println("Numbers of sum "+x+ " are "+ arr[ans2[0]]+" "+ arr[ans2[1]]);
		}
	}
	
	//Time O(n^2), space O(1)
	private int[] bruteForce(int[] arr, int x) {
		for(int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length;j++) {
				if (arr[i]+arr[j] == x) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	//Time complexity O(n), space complexity O (n)
	private int[] findNums(int[] arr, int x) {
		Map<Integer, Integer> sumMap = new HashMap<>();
		for (int i=0; i< arr.length; i++) {
			int diff = Math.abs(arr[i]-x);
			if (sumMap.get(arr[i]) != null) {
				return new int[] {i, sumMap.get(arr[i])};
			}
			sumMap.put(diff, i);	
		}
		return null;
	}
}
