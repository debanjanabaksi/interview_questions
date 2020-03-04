package medium;
/*
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of lengths of all parts. 
 * You must make at least one cut. Assume that the length of rope is more than 2 meters.
 */
public class MaximumProductCuttingRope {

	public static void main(String[] args) {
		System.out.println("Max prod with recursion is "+ cutRopeRecurse(10));
		System.out.println("Max prod with DP is "+ cutRopeDP(10));

	}
	
	private static int cutRopeRecurse(int n) {
		int max = 0;
		if(n==0 || n ==1) {
			return 0;
		}
		
		for (int i = 1; i<=n; i++) {
			max = Math.max(max, Math.max(i*(n-i), cutRopeRecurse(n-i)*i));
		}
		
		return max;
	}
	
	private static int cutRopeDP(int n) {
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=0;
		for(int i = 1; i <= n; i++) {
			int max = 0;
			for(int j = 1; j<=i/2; j++) {
				System.out.println(" i and j "+ i +" "+j);
				max = Math.max(max, Math.max(j*(i-j), dp[i-j]*j));
				System.out.println("max is " + max);
			}
			dp[i] = max;
			System.out.println(" i is "+ i + " dp is "+dp[i]);
		}
		return dp[n];
	}

}
