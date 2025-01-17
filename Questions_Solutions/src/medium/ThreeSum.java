package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * output should not have duplicates
 * 
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list = threeSum(arr);
		for(List<Integer> l : list) {
			for(Integer i : l) {
				System.out.print(" "+i);
			}
			System.out.println();
		}
		

	}
	
	private static List<List<Integer>> threeSum(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for(int i = 0; i<arr.length -2; i++) {
			int j = i+1;
			int k = arr.length-1;
			if(i > 0 && arr[i]==arr[i-1]) {
				continue;
			}
			while (j<k) {
				if(j<arr.length && arr[j]==arr[j+1]) {
					j++;
					continue;
				}
				if(k<arr.length-1 && arr[k]== arr[k+1]) {
					k--;
					continue;
				}
				if(arr[i]+arr[j]+arr[k]<0) {
					j++;
				} else if (arr[i]+arr[j]+arr[k]>0) {
					k--;
				} else {
					List<Integer> l1 = new ArrayList<>();
					l1.add(arr[i]);
					l1.add(arr[j]);
					l1.add(arr[k]);
					output.add(l1);
					j++;
					k--;
				}
			}
		}
		return output;
	}

}
