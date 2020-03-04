package medium;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		LongestPalindromeSubsequence lps = new LongestPalindromeSubsequence();
        String str = "agbdba";
        String str2 = "abcb";
        System.out.println("Longest palindrome substring is : "+lps.longestPalindromicSubsequence(str));
        System.out.println("Count of palindromes : "+lps.countAllSubsequences(str));
        System.out.println("Longest palindrome substring is : "+lps.longestPalindromicSubsequence(str2));
        System.out.println("Count of palindromes: "+lps.countAllSubsequences(str2));
	}
	
	private int longestPalindromicSubsequence(String str) {
		int n =str.length();
		System.out.println("Length is "+n);
		int[][] T = new int[n][n];
		for (int i = 0; i<n ; i++) {
			T[i][i]=1;
		}
		for(int l=2; l<=n; l++ ) {
			for(int i = 0; i<n-l+1;i++) {
				int j = l+i-1;
				if(str.charAt(i)==str.charAt(j)&& l==2) {
					T[i][j]=2;
				} else if(str.charAt(i)==str.charAt(j)) {
					T[i][j]= T[i+1][j-1]+2;
				} else {
					T[i][j] = Math.max(T[i+1][j], T[i][j-1]);
				}
			}
		}
		for(int i=0;i<str.length();i++) {
        	for(int j=0;j<str.length();j++) {
        		System.out.print(" "+T[i][j]);
        	}
        	System.out.println();
        }
		
		int i=0; int j =n-1;
		int x=0; int y = T[0][n-1]-1;
		char[]c = new char[T[0][n-1]];
		StringBuilder str2 = new StringBuilder();
		//if there is a match diagonal+1 is the value of T[i][j] so we only include those.
		// else it wil be either of T[i+1][j] or T[i][j-1]
		//Add both the letters to the final result at beginning and end since we are filling palindrome
		while(i<n-1 && j>0) {
			if(T[i][j]!=T[i][j-1] && T[i][j]!=T[i+1][j]) {
				c[x]=str.charAt(i);
				c[y]=str.charAt(j);
				x++;
				y--;
				i++;
				j--;
				System.out.print(" diagonal"+" "+i+" "+j);
			} else if (T[i][j-1] > T[i+1][j]) {
				j--;
			} else {
				i++;
			}
		}
		System.out.println("\nSubsequence is ");
		System.out.println(c);
		return T[0][n-1];
	}
	
//	public int calculate1(char []str){
//        int T[][] = new int[str.length][str.length];
//        for(int i=0; i < str.length; i++){
//            T[i][i] = 1;
//        }
//        for(int l = 2; l <= str.length; l++){
//            for(int i = 0; i < str.length-l + 1; i++){
//                int j = i + l - 1;
//                if(l == 2 && str[i] == str[j]){
//                    T[i][j] = 2;
//                }else if(str[i] == str[j]){
//                    T[i][j] = T[i + 1][j-1] + 2;
//                }else{
//                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
//                }
//            }
//        }
//        for(int i=0;i<str.length;i++) {
//        	for(int j=0;j<str.length;j++) {
//        		System.out.print(" "+T[i][j]);
//        	}
//        	System.out.println();
//        }
//        return T[0][str.length-1];
//    }
	
	private int countAllSubsequences(String str) {
		int n = str.length();
		System.out.println("Length is "+n);
		int[][] T = new int[n][n];
		for (int i= 0; i<n;i++) {
			T[i][i]=1;
		}
		for(int l = 2; l<=n;l++) {
			for(int i = 0; i < n-l+1;i++) {
				int j = i+l-1;
				if(str.charAt(i)==str.charAt(j)) {
					T[i][j]=T[i+1][j]+T[i][j-1]+1;
				} else {
					T[i][j]=T[i+1][j]+T[i][j-1]-T[i+1][j-1];
				}
			}
		}
//		int i=0; int j =n-1;
//		int x=0; int y = T[0][n-1]-1;
//		char[]c = new char[T[0][n-1]];
//		StringBuilder str2 = new StringBuilder();
//		while(i<n-1 && j>0) {
//			if(T[i][j]!=T[i][j-1] && T[i][j]!=T[i+1][j]) {
//				c[x]=str.charAt(i);
//				c[y]=str.charAt(j);
//				x++;
//				y--;
//				i++;
//				j--;
//			}
//			System.out.println(c);
//		}
//		System.out.println("\nSubsequences are ");
//		System.out.println(c);
		
		return T[0][n-1];
	}

}
