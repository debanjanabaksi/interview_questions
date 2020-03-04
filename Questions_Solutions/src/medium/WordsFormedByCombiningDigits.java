package medium;

public class WordsFormedByCombiningDigits {

	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) {
		int[] digits = { 1, 2, 2 };

		String str = "";
		recur(digits, 0, str);

	}
	
	private static void recur(int[] digits, int i, String str) {
		if (i == digits.length) {
			System.out.println("\nWord formed " +str);
			return;
		}
		int sum = 0;
		for (int j=i; j<= Integer.min(i+1, digits.length -1); j++) {
			sum = (sum * 10) + digits[j];
			if(sum >0 && sum <=26) {
				
				recur(digits, j+1, str+ alphabet.charAt(sum-1));
			}
		}
		
//		if (i == digits.length)
//		{
//			// print the String
//			System.out.println(str);
//			return;
//		}
//
//		int sum = 0;
//
//		// process next two digits (ith and (i+1)th)
//		for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++)
//		{
//			sum = (sum * 10) + digits[j];
//
//			// if a valid char can be formed by taking one or both digits,
//			// append it to the output and recur for remaining digits
//			if (sum > 0 && sum <= 26) {
//				recur(digits, j + 1, str + alphabet.charAt(sum - 1));
//			}
//		}
	}

}
