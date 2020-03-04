package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String str = "this is a test string";
		String pat = "tist";
		String str2 = "ADOBECODEBANC";
		String pat2 = "ABC";
		String subString = findMinSubstringWindow(str, pat);
		System.out.println(subString);
		String subString2 = findMinSubstringWindow(str2, pat2);
		System.out.println(subString2);

		System.out.println(findSubString(str, pat));
		System.out.println(findSubString(str2, pat2));
	}

	private static String findMinSubstringWindow(String str, String pattern) {

		int l1 = str.length();
		int l2 = pattern.length();
		int min_window = Integer.MAX_VALUE;
		if (l1 < l2) {
			System.out.println("window does not exist");
			return "";
		}
		Map<Character, Integer> pat_map = new HashMap<>();
		Map<Character, Integer> str_map = new HashMap<>();
		for (int i = 0; i < l2; i++) {
			char c = pattern.charAt(i);
			pat_map.put(c, pat_map.getOrDefault(c, 0) + 1);
		}

		int start = 0, start_index = -1, count = 0;
		for (int j = 0; j < l1; j++) {
			char s = str.charAt(j);
			str_map.put(s, str_map.getOrDefault(s, 0) + 1);
			if (pat_map.getOrDefault(s, 0) != 0 && str_map.getOrDefault(s, 0) <= pat_map.getOrDefault(s, 0)) {
				count++;
			}
			if (count == l2) {
				while (str_map.getOrDefault(str.charAt(start), 0) > pat_map.getOrDefault(str.charAt(start), 0)
						|| pat_map.getOrDefault(str.charAt(start), 0) == 0) {
					if (str_map.getOrDefault(str.charAt(start), 0) > pat_map.getOrDefault(str.charAt(start), 0)) {
						str_map.put(str.charAt(start), str_map.getOrDefault(str.charAt(start), 0) - 1);
					}
					start++;
				}

				int window_len = j - start + 1;
				if (min_window > window_len) {
					min_window = window_len;
					start_index = start;
				}
			}
		}
		if (start_index == -1) {
			System.out.println("window does not exist ");
			return "";
		}
		return str.substring(start_index, start_index + min_window);
	}

	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		// check if string's length is less than pattern's
		// length. If yes then no such window can exist
		if (len1 < len2) {
			System.out.println("No such window exists");
			return "";
		}

		int hash_pat[] = new int[256];
		int hash_str[] = new int[256];

		// store occurrence ofs characters of pattern
		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

		// start traversing the string
		int count = 0; // count of characters
		for (int j = 0; j < len1; j++) {
			// count occurrence of characters of string
			hash_str[str.charAt(j)]++;

			// If string's char matches with pattern's char
			// then increment count
			if (hash_pat[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;

			// if all the characters are matched
			if (count == len2) {
				// Try to minimize the window i.e., check if
				// any character is occurring more no. of times
				// than its occurrence in pattern, if yes
				// then remove it from starting and also remove
				// the useless characters.
				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				// update window size
				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		// If no window found
		if (start_index == -1) {
			System.out.println("No such window exists");
			return "";
		}

		// Return substring starting from start_index
		// and length min_len
		return str.substring(start_index, start_index + min_len);
	}

}
