package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ManyShortQuestions {
	
	public static void main(String args[]) {
		System.out.println("Defanged ip for 128.0.0.0 is" + defang("128.0.0.0"));
		int arr[] = {1,2,2,1,1,3};
		int arr2[] = {-3,0,1,-3,1,1,1,-3,10,0};
		int arr3[] = {1,2,2,1};
		System.out.println("Array has unique count ? " + uniqueOccurrences(arr));
		System.out.println("Array2 has unique count ? " + uniqueOccurrences(arr2));
		System.out.println("Array3 has unique count ? " + uniqueOccurrences(arr3));
	}
	
	//Defanging wifi address 
	//A defanged IP address replaces every period "." with "[.]".
	//Input: address = "1.1.1.1"
	//Output: "1[.]1[.]1[.]1"
	
	private static String defang(String ip)  {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<ip.length();i++) {
			if (ip.charAt(i)=='.') {
				sb.append("[.]");
			} else {
				sb.append(ip.charAt(i));
			}
		}
		return sb.toString();
	}
	
	// Given an array of integers arr, write a function that returns true if and
	// only if the number of occurrences of each value in the array is unique.
	// Input: arr = [1,2,2,1,1,3]
	// Output: true
	// Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two
	// values have the same number of occurrences.
	
	//Time complexity O(n) ( considering iteration and insertion into hash map) space complexity O(n) 
	// 1 map and 1 set 
	
	public static boolean uniqueOccurrences (int arr[]) {
		Map<Integer, Integer> countOccurrence = new HashMap<>();
		for (int element : arr) {
			Integer count = countOccurrence.get(element);
			if (count == null ) {
				count = 0;
			}
			countOccurrence.put(element, count+1);
		}
		HashSet<Integer> unique = new HashSet<Integer>(countOccurrence.values());
		for (int el : unique) {
			System.out.println(el);
		}
		return (unique.size() !=1);
	}
}
