package medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		int input[] = {3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10};
        int n = arr.length; 
        System.out.println("Length of lis is " + longestDP(arr) + "\n" ); 
        System.out.println("Length of lis is " + longest( arr) + "\n" ); 
        System.out.println("Length of lis is " + longestDP(input) + "\n" ); 
        System.out.println("Length of lis is " + longest(input) + "\n" ); 
	}
	
	private static int longestDP(int arr[]) {
		int[] lis = new int[arr.length];
		Arrays.fill(lis, -1);
		lis[0] = 1;
		for(int i = 1; i<arr.length; i++) {
			for (int j = 0; j<i; j++) {
				if(arr[i]> arr[j] && lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
		}
		int max = 0;
		for(int i = 1; i<arr.length; i++) {
			if(lis[i]>max) {
				max = lis[i];
			}
		}
		return max;
	}
	//O(nlog(n))time O(n) space
	private static int longest(int a[]) {
		int n = a.length;
		int[] T = new int[n];
		int[] R = new int[n];// R stores index of prev longest subsequence upto that pt used to reconstruct subs
		int len = 0;// len of longest subs till now. actually there will always exist incr subs of length 1 but to fit indexes we start from 0, add 1 while returning
		Arrays.fill(R, -1);
		T[0] = 0; // T stores indexes of longest subsequence till that pt. used to get length
		
		for(int i =1; i<n; i++) {
			if(a[i] < a[T[0]]) {// smaller than subs beg
				T[0] = i; // beg of new subs
			} else if(a[i] > a[T[len]]) {// larger than last in subs
				len++;// incr in subs len
				T[len] = i;//  index of new max
				R[T[len]] = T[len-1];// trace new max's index to prev max's index to construct subs
			} else { // value lies in between, so do binary search to find pos to insert it. 
				int index = ceilIndex(a, T, i, a[i]);
				T[index] = i;
				R[T[index]] = T[index-1];
			}
				
		}
		System.out.println("Longest increasing subsequence ");
		int index = T[len];
		while(index!=-1) {
			System.out.print(a[index]+ " ");
			index = R[index];
		}
		System.out.println();
		return len+1;// add 1 since started from 0, check above.
	}
	
	private static int ceilIndex(int[] arr, int[]T, int end, int num) {
		int start = 0;
		int middle;
		int len = end;
		while(start<=end) {
			middle = (start+end)/2;
			if(middle<len &&  arr[T[middle]] < num  && num<=arr[T[middle+1]]) {
				return middle+1;
			} else if (num > arr[T[middle]]) {
				start = middle+1;
			} else {
				end = middle-1;
			}
		}
		return -1;
	}

}
