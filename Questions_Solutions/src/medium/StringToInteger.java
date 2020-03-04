package medium;
/**
 * Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
 * 
 *
 */
public class StringToInteger {

	public static void main(String[] args) {
		
		StringToInteger atoi = new StringToInteger();
		String str1 = "42";
		String str2 = "  -42";
		String str3 = "4193 with words";
		String str4 = "words and 987";
		String str5 = "+67";
		String str6 = "-91283472332";
		String str7 = "2147483648";
		String str8 = "2147483647";
		
		
		System.out.println("String "+str1+" is converted to "+atoi.stringToInt(str1));
		System.out.println("String "+str2+" is converted to "+atoi.stringToInt(str2));
		System.out.println("String "+str3+" is converted to "+atoi.stringToInt(str3));
		System.out.println("String "+str4+" is converted to "+atoi.stringToInt(str4));
		System.out.println("String "+str5+" is converted to "+atoi.stringToInt(str5));
		System.out.println("String "+str6+" is converted to "+atoi.stringToInt(str6));
		System.out.println("String "+str7+" is converted to "+atoi.stringToInt(str7));
		System.out.println("String "+str8+" is converted to "+atoi.stringToInt(str8));

	}
	
	private int stringToInt(String str) {
		str = str.trim();
		int n = str.length();
		int sign = str.charAt(0)=='-'?-1:1;
		int index;
		if(sign<0) {
			index = 1;
		} else if(str.charAt(0)=='+') {
			index = 1;
		} else {
			index = 0;
		}
		if(!isNumeric(str.charAt(index))){
			return 0;
		}
		int base = 0;
		while(index < n ) {
			if(!isNumeric(str.charAt(index))) {
				index++;
				continue;
			}
			int digit = str.charAt(index)-'0';
			if(isOverflow(base,digit)) {
				return handleOverflow(base, sign);
			}
			base = base*10 + digit;
			index++;
		}
		return base*sign;
	}
	
	private boolean isNumeric(char c) {
		return (c-'0'>= 0&& c-'0'<=9);
	}
	
	private boolean isOverflow(int base, int digit) {
		int threshold = Integer.MAX_VALUE/10;
		// max int is 2147483648, if base == 2147483640 and digit >7, int will become 2147483648 or more so checking for digit
		// can also go for >= threshold, but this allows at least some numbers > 2147483640
		if(base > threshold || (base == threshold && digit >7)) {
			return true;
		}
		return false;
	}
	
	private int handleOverflow(int base, int sign) {
		return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	}

}
