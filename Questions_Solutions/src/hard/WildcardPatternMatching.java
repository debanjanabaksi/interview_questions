package hard;

public class WildcardPatternMatching {

	public static void main(String[] args) {
		String str = "baaabab";
		String pattern = "*****ba*****ab";
		String s="acdcb";
		String p = "a*c?b";
		if (patternMatch(s, p))
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	static boolean patternMatch(String str, String ptrn) {
		int n = str.length();
		int m = ptrn.length();
		// only empty can match empty
		if (n == 0) {
			return m == 0;
		}
		boolean lookup[][] = new boolean[n + 1][m + 1];
		// empty chars match
		lookup[0][0] = true;
		// only * can match empty
		for (int j = 1; j <= m; j++) {
			if (ptrn.charAt(j - 1) == '*') {
				lookup[0][j] = lookup[0][j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// hanlde *
				if (ptrn.charAt(j - 1) == '*') {
					lookup[i][j] = lookup[i][j - 1] || lookup[i - 1][j];
				} else if (ptrn.charAt(j - 1) == '?' || ptrn.charAt(j - 1) == str.charAt(i - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1];
				} else {
					lookup[i][j] = false;
				}
			}
		}
		return lookup[n][m];
	}

}
