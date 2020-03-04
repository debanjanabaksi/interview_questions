package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 }; 
        int k = 3; 
        slidingWindowMaximum(arr, k);

	}
	
	private static void slidingWindowMaximum(int arr[], int k) {
		Deque<Integer> dq = new ArrayDeque<>();
		int[] result = new int[arr.length-k+1];
		for(int i = 0 ; i < arr.length; i++) {
			
			while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
			while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
				dq.removeFirst();
			}
			//to handle first window and not print till the window is formed
			if(i+1 >=k) {
				// adjust to 0 for 1st index
				result[i+1 - k ] = arr[dq.peekFirst()];
			}
		}
		System.out.println("result length is "+result.length );
		for (int i = 0; i < result.length;i++) {
			System.out.print(result[i]+" ");
		}
	
	}

}
