package medium;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] a1 = {-1,6,2,0,7,9};
		int[] a2 = {2,3,-2,4};
		int[] a3 = {-2,0,-1};
		int[] a4 = { 6, -3, -10, 0, 2 };
		int[] a5 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum product is "+maxSubArray(a1));
		System.out.println("Maximum product is "+maxSubArray(a2));
		System.out.println("Maximum product is "+maxSubArray(a3));
		System.out.println("Maximum product is "+maxSubArray(a4));
		System.out.println("Maximum sum is "+maxSumSubArray(a5));
	}
	
	private static final int maxSubArray(int[]a) {
		int curr_max = a[0];
		int curr_min = a[0];
		int prev_max = a[0];
		int prev_min = a[0];
		int ans = a[0];
		for(int i = 1; i< a.length; i++) {
			curr_max = Math.max(prev_max*a[i], Math.max(prev_min*a[i], a[i]));
			curr_min = Math.min(prev_max*a[i], Math.min(prev_min*a[i], a[i]));
			ans = Math.max(ans,  curr_max);
			prev_max = curr_max;
			prev_min = curr_min;
		}
		return ans;
	}

	private static final int maxSumSubArray(int[]a) {
		int curr_max = a[0];
		int curr_min = a[0];
		int prev_max = a[0];
		int prev_min = a[0];
		int ans = a[0];
		for(int i = 1; i< a.length; i++) {
			curr_max = Math.max(prev_max+a[i], Math.max(prev_min+a[i], a[i]));
			curr_min = Math.min(prev_max+a[i], Math.min(prev_min+a[i], a[i]));
			ans = Math.max(ans,  curr_max);
			prev_max = curr_max;
			prev_min = curr_min;
		}
		return ans;
	}
}
