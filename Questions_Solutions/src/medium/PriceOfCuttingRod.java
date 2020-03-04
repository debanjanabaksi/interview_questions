package medium;
/*
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 */
public class PriceOfCuttingRod {

	public static void main(String[] args) {
		 int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
	        int size = arr.length; 
	        System.out.println("Maximum Obtainable Value by recursion is " + 
	        		cutRodRecur(arr, size)); 
	        System.out.println("Maximum Obtainable Value by DP is " + 
	        		cutRodDp(arr, size)); 

	}
	
	private static int cutRodRecur(int[] price, int n) {
		int max = 0;
		for(int i =0; i<n; i++) {
			max = Math.max(max, price[i]+cutRodRecur(price, n-i-1) );
		}
		return max;
	}
	
	private static int cutRodDp(int[] price, int n) {
		int dp[] = new int[n+1];
		dp[0] = 0;
		for (int i = 0; i<=n; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				max = Math.max(max, price[j]+dp[i-j-1]);
			}
			dp[i] = max;
		}
		
		return dp[n];
	}


}
