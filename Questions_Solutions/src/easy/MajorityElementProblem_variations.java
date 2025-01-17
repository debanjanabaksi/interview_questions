package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * 
 *
 */
public class MajorityElementProblem_variations {

//  Input: [5,1,5,2,5,3,5,4]
//	Output: 5

	// 4 <= A.length <= 10000
	// 0 <= A[i] < 10000
	// A.length is even
	public static void main(String args[]) {
		int[] input = { 5, 1, 5, 2, 5, 3, 5, 4 };
		int[] input2 = { 2, 1, 5, 2, 3, 2 };
		int[] input3 = {1,3,4,1};
		nRepeatedElements(input);
		nRepeatedElements(input2);
		nRepeatedElements(input3);
		nRepeatedElementsConstantSpace(input);
		nRepeatedElementsConstantSpace(input2);
		nRepeatedElementsConstantSpace(input3);
		int[] inputMajority = {3, 3, 4, 2, 4, 4, 2, 4, 4};
		int[] noMajority = {3, 3, 4, 2, 4, 4, 2, 4};
		findMajorityElement(inputMajority);
		findMajorityElement(noMajority);
		int[]inputRepeated = {1, 2, 3, 1, 3, 6, 6};
		findDuplicates(inputRepeated);
		int[] inputrepeated2 = {1, 6, 3, 1, 3, 6, 6} ;
		findDuplicatesPrintOnce(inputrepeated2);
		//printRepeating(inputrepeated2, 7);
	}

	/*
	 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
	 * these elements is repeated N times.
	 * 
	 * Return the element repeated N times. Input: [5,1,5,2,5,3,5,4] Output: 5
	 * 
	 * 4 <= A.length <= 10000 0 <= A[i] < 10000 A.length is even
	 */

	// Straight fwd technique On(n) time O (n) space
	// Can use map too. Add in map check count, if any has count > 1 then return it.
	// But that needs 2 for loops
	private static void nRepeatedElements(int[] arr) {
		Set countSet = new HashSet<>();
		for (int el : arr) {
			if (countSet.contains(el)) {
				System.out.println(el);
				return;
			}
			countSet.add(el);
		}
		System.out.println("Not found");
	}
	
	/* Solution 2
	 * If a distance between them is at least 𝑑, the array would be at least 𝑑⋅(𝑁−1)+1 long. 
	 * Since we know that it is 2𝑁 long, we can conclude that 𝑑 ≤ 2𝑁−1/𝑁−1, which is effectively 2 for N > 2. 
	 * It is enough to compare each a[i] with a[i+1] and a[i+2]. The space complexity is now constant.
	 * 
	 * Since half the elements are same, I think we can assume every second element will have a repeating?
	 * the second solution is based on the distribution regularity of the repeated items, 
	 * they are either neighbors at least once or they are done apart with one item in between at least once
	 * Solution is O(n) time and O(1) space
	 */
	private static void nRepeatedElementsConstantSpace(int [] arr) {
		int n = arr.length;
		for (int i=0; i< n-2; i++) {
			if (arr[i] == arr[i+1] || arr[i] == arr[i+2]) {
				System.out.println(arr[i]);
				return;
			}
		}
		// Assuming that repeating element is definitely present, if not found before then see last
		// use case will is for array like : {1,3,4,1}
		System.out.println(arr[n-1]);
	}

	/*
	 * Write a function which takes an array and prints the majority element (if it
	 * exists), otherwise prints “No Majority Element”. A majority element in an
	 * array A[] of size n is an element that appears more than n/2 times (and hence
	 * there is at most one such element). Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
	 * Output : 4
	 * 
	 * Input : {3, 3, 4, 2, 4, 4, 2, 4} Output : No Majority Element
	 */
	// simple logic can again be a map where we check the count for n/2 and return. Though O (n) time, we need O(n) space.
	// O(1) space logic involves first identifying potential candidate and then checking if that element is indeed majority element.
	// two iterations needed O(n) time and O(1) space
	// If an element matches increase its count , if not decrease it. 
	// Basic idea of the algorithm is that if we cancel out each occurrence of an element e 
	//with all the other elements that are different from e then e will exist till end if it is a majority element.
	
	private static void findMajorityElement(int [] arr) 
	{
		int candidate = findCandidate(arr);
		if(isMajority(arr, candidate)) {
			System.out.println("Majority is : "+ candidate);
		} else{
			System.out.println("No Majority element");
		}
		
	}
	private static int findCandidate(int[] arr) {
		int majority = 0;
		int count = 1;
		for (int i= 1; i< arr.length; i++) {
			if(arr[majority] == arr[i]) {
				count++;
			} else {
				count--;
			} // if value becomes 0, move to next element
			if ( count == 0) {
				majority = i;
				count = 1;
			}
		} 
		return arr[majority];
	} 
	private static boolean isMajority(int[] arr, int candidate) {
		int count =0;
		int n = arr.length;
		for (int el : arr) {
			if(el == candidate) {
			count++;
			}
		}
		if (count> n/2 ) {
			return true;
		} else {
			return false;
		}
	}
	
	/* Find duplicates in O(n) time and O(1) extra space 
	 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
	 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
	 */
	// since elements are within range of the array size, they can be used as index. They can be used to mark visited elements
	// Number which is repeated will be visited more than once. E.g i = 1, a[a[i]]= a[a[1]] suppose a[1] = 3 and a[3] is 2 so now a[3] = -2
	// If 3 is present twice, let's say a[5] = 3, so when i=5, a[a[5]] = a[3] = -2. So we know that a[3] is already visited meaning that 3 is present twice atleast.
	private static void findDuplicates(int[] arr) {
		System.out.println();
		for (int i = 0; i< arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
			} else {
				System.out.print(" "+ Math.abs(arr[i]));
			}
		}
	}
	// Above solution prints an element multiple times. E.g {1, 6, 3, 1, 3, 6, 6} gives 1 3 6 6
	// Instead of marking value as negative we keep adding n to it, for traversing we do %n of the value so index falls in range
	// if any value satisfies value/n > 1 , then that index was present multiple times as a value.
	// n=7, a[a[i]]= a[a[1]] suppose a[1] = 3. index is a[i]%7 = 3%7 = 3. So a[3] = 3+7 = 10
	// If 3 occurs again at say a[5] = 3. So a[5]%7 = 3%7 = 3.
	// so a[3] = a[3] + 7 = 10+7 = 17. If a[7] also = 3, again a[7]%7 = 3%7 = 3. So a[3] = a[3]+7 = 17+7 = 24
	// So the element /index which has value such that value/n > 1, is a value in the array which has appeared multiple times. Its printed only once
	// In principle just keep adding n. To continue with using value as an index use value%n as index.
	private static void findDuplicatesPrintOnce(int[] arr) {
		System.out.println();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(" "+arr[i]);
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			//System.out.println();
			//System.out.print(" i and arr[i]"+i+" "+arr[i]);
			int index = arr[i] % n;
			//System.out.print(" index "+index);
			arr[index] = arr[index] + n;
			//System.out.print(" arr[index]"+arr[index]);
		} 
		for (int i = 0; i < n; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println("\nDuplicates are : ");
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				System.out.print(" " + i);
			}
		}
	} 
	/// FROM GeeksForGeeks
	static void printRepeating(int arr[], int n) 
	{ 
	    // First check all the values that are 
	    // present in an array then go to that 
	    // values as indexes and increment by 
	    // the size of array 
	    for (int i = 0; i < n; i++) 
	    { 
	        int index = arr[i] % n; 
	        arr[index] += n; 
	    } 
	  
	    // Now check which value exists more 
	    // than once by dividing with the size 
	    // of array 
	    for (int i = 0; i < n; i++) 
	    { 
	        if ((arr[i]/n) > 1) 
	            System.out.println(i +" "); 
	    } 
	} 
}
