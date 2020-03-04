package hard;

public class ShortestPalindrome {

	public static void main(String[] args) {
		String s1 = "aacecaaa";
		String s2 = "abcd";
		String s3 = "banana";
		System.out.println("Shortest palindrome created is : "+shortestPalindrome(s1));
		System.out.println("Shortest palindrome created is : "+shortestPalindrome(s2));
		System.out.println("Shortest palindrome created is : "+shortestPalindrome(s3));
		System.out.println("Shortest palindrome created is : "+shortestPalindromeKMP(s1));
		System.out.println("Shortest palindrome created is : "+shortestPalindromeKMP(s2));
		System.out.println("Shortest palindrome created is : "+shortestPalindromeKMP(s3));
		
		
		
	}
	
	// recursion based. O(n2) time O(n) space for extra string
	public static String shortestPalindrome(String str) {
		int n = str.length();
		int i=0;
		int j= n-1;
		while(j>=0) {
			if(str.charAt(i)==str.charAt(j)) {
				//System.out.println("matching is : "+str.charAt(i)+" "+str.charAt(j));
				i++;
			}
			j--;
		}
		//System.out.println("i is : "+i);
		if(i==n) {
			return str;
		}
		String suffix = str.substring(i);
		//System.out.println("Suffix is : "+suffix);
		String prefix = new StringBuilder(suffix).reverse().toString();
		//System.out.println("Prefix is : "+prefix);
		String mid = shortestPalindrome(str.substring(0,i));
		//System.out.println("mid is : "+mid);
		return prefix+mid+suffix;
		
	}
	
	private static int[] computePrefixArray(String str) {
		int n = str.length();
		int index = 0;
		int[]lps = new int[n];
		int i = 1;
		lps[0]= 0;
		while(i<n) {
			if(str.charAt(i)== str.charAt(index)) {
				lps[i]= index+1;
				index++;
				i++;
			} else if(index!=0) {
				index = lps[index-1];
			} else {
				lps[i]=0;
				i++;
			}
		}
		return lps;
	}
	
	//KMP based O(n) time and O(n) space
	
	public static String shortestPalindromeKMP(String str) {
		int n = str.length();
		String rev_str = new StringBuilder(str).reverse().toString();
		String l = str+rev_str;
		//int[] lps = computePrefixArray(l);
		int lps[] = new int[l.length()];
//		lps[0]=0;
//		for(int i = 1; i<l.length();i++) {
//			int j = lps[i-1];
//			while(j>0 && l.charAt(i)!=l.charAt(j)) {
//				j = lps[j-1];
//			}
//			if(l.charAt(i)==l.charAt(j)) {
//				lps[i]=j+1;
//			}
//		}
		lps = computePrefixArray(l);
		//part of the reversed string which is not in the suffix+str
		//reversed str and str have same length. O-start pt of suffix is the substring needed from reverse str
		//start of suffix is length - suffix length. suffix length is in lps last element which is l-1
		return rev_str.substring(0, str.length()-lps[l.length()-1])+str;
	}
	
	public  static String shortestPal(String s)
    {
        String rev_s = new StringBuilder(s).reverse().toString();
        //use special character to avoid overlap
        String l = s + "#" + rev_s; 
         
        int[] p = new int[l.length()];
         
        //build KMP table.
        //i -> suffix boundary
        //j -> prefix boundary
         
         
        for(int i=1; i<l.length(); i++)
        {
            //update prefix boundary to previous match position
            int j = p[i-1];
             
            //move to the last prefix boundary match
            while(j>0 && l.charAt(i)!=l.charAt(j))
                j = p[j-1];
             
            //if prefix boundary matches suffix boundary,
            //increase prefix length 
            if(l.charAt(i) == l.charAt(j)) p[i] = j + 1;
        }
         
        return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
    }

}
