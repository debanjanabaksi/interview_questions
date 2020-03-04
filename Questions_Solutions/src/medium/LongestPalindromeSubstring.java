package medium;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String str1 = "forgeeksskeegfor";
		String str2 = "babad";
		String str3 = "cbbd";
		longestPalindromeDP(str1);
		longestPalindromeDP(str2);
		longestPalindromeDP(str3);
		System.out.println(longestPalindromeExpansion(str1));
		System.out.println(longestPalindromeExpansion(str2));
		System.out.println(longestPalindromeExpansion(str3));
		System.out.println("Count of substring palindromes "+ countPalindromeSubstring(str1));
		System.out.println("Count of substring palindromes "+ countPalindromeSubstring(str2));
		System.out.println("Count of substring palindromes "+ countPalindromeSubstring(str3));
		System.out.println("Count of substring palindromes "+ countPalindromeSubstring("aaa"));
		System.out.println("Count of substring palindromes "+ countPalindromeSubstring("abc"));
//		char[]s1= "aaa".toCharArray();
//		char[]s2 = "abc".toCharArray();
//		System.out.println("Count of substring palindromes "+CountPS(s1,3));
//		System.out.println("Count of substring palindromes "+CountPS(s2,3));
	}
	
	public static void longestPalindromeDP(String str) {
		if (str.length() == 0) {
			return;
		}
		int n = str.length();
		boolean[][] t = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			t[i][i] = true;// str of length 1
		}
		//length 2
		int begin = 0;
		int maxLength = 1;
		for(int i=0;i<n-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				t[i][i+1]=true;
				begin =i;
				maxLength =2;
			}
		}
//		//length 3 and above increasing length one at a time
//		for (int i = 3; i < n; i++) {
//			//end index accordingly
//			for (int j = 0; j < n-i +1; j++) {
//				int k = i+j-1;
//				if (t[i + 1][k - 1] && (str.charAt(i) == str.charAt(k))) {
//					t[i][k] = true;
//					if(i>maxLength) {
//						begin = i;
//						maxLength = i;
//					}
//				}
//			}
//		}
		
		// Check for lengths greater than 2. k is length 
        // of substring 
        for (int k = 3; k <= n; ++k) { 
              
                  // Fix the starting index 
            for (int i = 0; i < n - k + 1; ++i)  
            { 
                // Get the ending index of substring from 
                // starting index i and length k 
                int j = i + k - 1; 
  
                // checking for sub-string from ith index to 
                // jth index iff str.charAt(i+1) to  
                // str.charAt(j-1) is a palindrome 
                if (t[i + 1][j - 1] && str.charAt(i) ==  
                                          str.charAt(j)) { 
                    t[i][j] = true; 
  
                    if (k > maxLength) { 
                        begin = i; 
                        maxLength = k; 
                    } 
                } 
            } 
        } 
		System.out.println(str.substring(begin, begin+maxLength)+" length is "+maxLength);
	}
	
	public static String longestPalindromeExpansion(String str) {
		if (str.length() == 0) {
			return "";
		}
		int n = str.length();
		
		String longest ="";
		for(int i=0; i<n;i++) {
			String temp = expand(str,i,i);
			if(temp.length()>longest.length()) {
				longest = temp;
			}
			temp = expand(str,i,i+1);
			if(temp.length()>longest.length()) {
				longest = temp;
			}
			
		}
		return longest;
	}
	
	public static String expand(String s, int begin, int end) {
		while(begin>=0&&end<s.length()&&s.charAt(begin)==s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin+1,end);
	}
	
	//find count of all palindrome substrings
	public static int countPalindromeSubstring(String str) {
		int n = str.length();
		int[][]DP = new int[n][n];
		boolean[][]P = new boolean[n][n];
		for(int i = 0; i<n;i++) {
			P[i][i]=true;
			DP[i][i]=1;
		}
		for(int i=0; i<n-1;i++) {
			if(str.charAt(i)==str.charAt(i+1)) {
				P[i][i]=true;
				DP[i][i+1]=2;
			}
		}
		for(int l = 2; l<=n;l++) {
			for(int i=0; i<n-l+1;i++) {
				int j =l+i-1;
				if(str.charAt(i)==str.charAt(j)&&P[i+1][j-1]) {
					P[i][j]=true;
				}
				if(P[i][j]) {
					DP[i][j]=DP[i+1][j]+DP[i][j-1]+1 -DP[i+1][j-1];
				} else {
					DP[i][j]=DP[i+1][j]+DP[i][j-1] -DP[i+1][j-1];
				}
			}
		}
			
		return DP[0][n-1];
	}
	//dont use
	static int CountPS(char str[], int n) 
    { 
        // create empty 2-D matrix that counts all palindrome 
        // substring. dp[i][j] stores counts of palindromic 
        // substrings in st[i..j] 
        int dp[][] = new int[n][n]; 
       
        // P[i][j] = true if substring str[i..j] is palindrome, 
        // else false 
        boolean P[][] = new boolean[n][n]; 
       
        // palindrome of single length 
        for (int i= 0; i< n; i++) 
            P[i][i] = true; 
       
        // palindrome of length 2 
        for (int i=0; i<n-1; i++) 
        { 
            if (str[i] == str[i+1]) 
            { 
                P[i][i+1] = true; 
                dp[i][i+1] = 1 ; 
            } 
        } 
       
        // Palindromes of length more than 2. This loop is similar 
        // to Matrix Chain Multiplication. We start with a gap of 
        // length 2 and fill the DP table in a way that gap between 
        // starting and ending indexes increases one by one by 
        // outer loop. 
        for (int gap=2 ; gap<n; gap++) 
        { 
            // Pick starting point for current gap 
            for (int i=0; i<n-gap; i++) 
            { 
                // Set ending point 
                int j = gap + i; 
       
                // If current string is palindrome 
                if (str[i] == str[j] && P[i+1][j-1] ) 
                    P[i][j] = true; 
       
                // Add current palindrome substring ( + 1) 
                // and rest palindrome substring (dp[i][j-1] + dp[i+1][j]) 
                // remove common palindrome substrings (- dp[i+1][j-1]) 
                if (P[i][j] == true) 
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1]; 
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1]; 
            } 
        } 
       
        // return total palindromic substrings 
        return dp[0][n-1]; 
    } 
      

}
