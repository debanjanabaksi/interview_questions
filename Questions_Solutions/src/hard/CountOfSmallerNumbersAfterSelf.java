package hard;

import java.util.Arrays;

/*
 *  You are given an integer array nums and you have to return a new counts array.
 *  The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *  Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 */
public class CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int[] ip = {5,2,6,1};
		CountOfSmallerNumbersAfterSelf countSmaller = new CountOfSmallerNumbersAfterSelf();
		int[] ans = countSmaller.countByMergeSort(ip);
		System.out.println("\ncount array : ");
		for(int i =0; i< ans.length; i++) {
			System.out.print(ans[i]+" ");
		}

	}
	
	private int[] countByMergeSort(int[] arr) {
		int n = arr.length;
		int count[] = new int[n];
		Num[] num = new Num[n];
		Arrays.fill(count, 0);
		for (int i = 0; i <n; i++) {
			num[i] = new Num(arr[i],i);
		}
		for(int i =0; i< num.length; i++) {
			System.out.print(num[i].val+" ");
		}
		System.out.println();
	  Num[] a =  mergeSort(num, 0, n-1, count);
	  System.out.println(" sorted array : ");
	   for(int i =0; i< a.length; i++) {
			System.out.print(a[i].val+" ");
		}
	   return count;
	}
	
	
	private Num[] mergeSort(Num[] num, int start, int end, int[] count) {
		if (start > end) {
			return new Num[]{};
		}
		 if(start == end) {
			 return new Num[] {num[start]};
		 }
		 int mid = start+(end-start)/2;
		 Num[] left = mergeSort(num, start, mid, count);
		 Num[] right = mergeSort(num, mid+1, end, count);
		
		 return  merge(left, right,count);
	}


	private Num[] merge(Num[] left, Num[] right, int[] count) {
		Num[] temp = new Num[left.length+right.length];
		int index = 0;
		int i =0, j=0;
		System.out.println("left length  "+ left.length + " right length "+ right.length);
		while(i < left.length && j < right.length) {
			if(left[i].val > right[j].val) {
				int a = count[left[i].index] + right.length - j;
				count[left[i].index] = count[left[i].index] + right.length - j;
				temp[index++] = left[i];
				i++;
			} else {
				temp[index++] = right[j];
				j++;
			}
		}
		
		while(i<left.length) {
			temp[index++] = left[i++];
		}
		while(j<right.length) {
			temp[index++] = right[j++];
		}
		return temp;
	}


	private class Num {
		int val;
		int index;
		
		Num(int val, int in) {
			this.val = val;
			this.index = in;
		}
	}

}
