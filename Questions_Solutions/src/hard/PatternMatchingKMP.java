package hard;

//O(m+n) time and O(m) space m is pattern length and n is string length
public class PatternMatchingKMP {

	public static void main(String[] args) {
		 String str = "abcxabcdabcdabcy";
	        String subString = "abcdabcy";
	       
	        boolean result = kmp(str, subString);
	        System.out.print(result);

	}
	
	private static int[] computeTempArray(String pattern) {
		int n = pattern.length();
		int [] lps = new int[n];
		int index = 0;
		int i=1;
		lps[0]=0;
		while(i<n) {
			if(pattern.charAt(i)==pattern.charAt(index)) {
				lps[i]=index+1;
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
	
	private static boolean kmp(String str, String pattern) {
		int[] lps = computeTempArray(pattern);
		
		int i=0;
		int j=0;
		
		while(i < str.length() && j < pattern.length()) {
			if(str.charAt(i)== pattern.charAt(j)) {
				i++;
				j++;
			} else if(j!=0) {
				j = lps[j-1];
			} else {
				i++;
			}
		}
		if(j==pattern.length()) {
			return true;
		}
		return false;
	}
}
