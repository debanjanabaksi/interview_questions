package medium;

import java.util.PriorityQueue;

public class FindKthLargestElement {

	public static void main(String[] args) {
		int[] arr = {7,10,4,3,20,15};
		int k = 3;
		
		System.out.println("Kth largest using heap "+ findKthUsingHeap(arr, k));
		System.out.println("Kth largest using quick select "+ findKthUsingQuickSelect(arr, k));

	}
	
	private static int findKthUsingHeap(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i< arr.length; i++) {
			pq.add(arr[i]);
			if(pq.size()>k) {
				pq.remove();
			}
		}
		return pq.peek();
	}
	
	private static int findKthUsingQuickSelect(int[] arr, int k) {
		if(k<1 ||  k>arr.length ) {
			return 0;
		}
		return getKth(arr.length-k, arr, 0, arr.length-1);
	}
	
	private static int getKth(int k, int[] arr, int low, int high) {
		int num = arr[low];
		int x = low;
		int y = high+1;
		while(y>x) {
			
			while(x<high && arr[++x]<num);
			while(y> low && arr[--y]>num);
			if(y>x) {
				int temp = arr[x];
				arr[x] = arr[y];
				arr[y] = temp;
			}
		}
		int temp = arr[y];
		arr[y]= arr[low];
		arr[low] = temp;
		
		if(k == y) {
			return arr[y];
		} else if(k<y)
			return getKth(k, arr, low, y-1);
		else 
			return getKth(k, arr, y+1, high);
		
	}

}
