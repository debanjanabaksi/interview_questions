package medium;
/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *  'A' -> 1
    'B' -> 2
	...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays {

	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		String s = "226";
		System.out.println("Number of ways to decode "+s+" is : "+dw.decodeWays(s));


	}
	
	public int decodeWays(String s) {
		int dp[] = new int[s.length()+1];
	
		dp[0] = 1;// if empty string only 1 way to decode it i.e. no way
		dp[1] = s.charAt(0) == 0 ? 0 : 1;
		System.out.println("char at  0 "+s.charAt(0));
		
		
		for(int i = 2; i <= s.length(); i ++) {
			int oneDigit = Integer.valueOf(s.substring(i-1, i));
			System.out.println("char  and int "+s.substring(i-1, i)+ " "+oneDigit);
			
			if( oneDigit >=1) {
				System.out.println("dp["+i+"]"+" "+dp[i]);
				dp[i] += dp[i-1];
				System.out.println("dp["+i+"] now"+" "+dp[i]);
			} 
			int twoDigit = Integer.valueOf(s.substring(i-2, i));
			System.out.println("char  and int "+s.substring(i-2, i)+ " "+twoDigit);
			if(twoDigit >= 10 && twoDigit <= 26) {
				System.out.println("dp["+i+"]"+" "+dp[i]);
				dp[i]+= dp[i-2];
				System.out.println("dp["+i+"] now"+" "+dp[i]);
			}
		}
		
		return dp[s.length()];
		
	}

}
