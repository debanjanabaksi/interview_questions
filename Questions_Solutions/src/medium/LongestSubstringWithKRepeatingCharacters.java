package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKRepeatingCharacters {

	public static void main(String[] args) {
		String s1 = "aaabb";
		String s2 = "ababbc";
		int k1= 3;
		int k2 = 2;
		System.out.println("Longest substring of " + s1 + " length "+ k1 + " is "+ findLongestSubstring(s1, k1));
		System.out.println("Longest substring of "+ s2+ " of length "+ k2 + " is "+ findLongestSubstring(s2, k2));
		
		String str = "geeksforgeeks"; 
        int k = 2; 
        System.out.println("\nLongest subsequence of "+ str+ " of length "+ k + " is "+ findLongestSusequence(str, k));
	}
	
	private static int findLongestSubstring(String s, int k) {
		if (k == 0) {
			return 0;
		}
		Map<Character, Integer> countMap = new HashMap<>();
		Set<Character> lessSet = new HashSet<>();
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if(countMap.containsKey(s.charAt(i))) {
				countMap.put(s.charAt(i), countMap.get(s.charAt(i))+1);
			} else {
				countMap.put(s.charAt(i), 1);
			}
		}
		for (Map.Entry<Character,Integer>entry : countMap.entrySet()) {
			if(entry.getValue()<k) {
				lessSet.add(entry.getKey());
			}
		}
		if(lessSet.isEmpty()) {
			System.out.println(s);
			return s.length();
		}
		int i = 0, j = 0;
		while(j < s.length()) {
			if(lessSet.contains(s.charAt(j))) {
				if(i!=j && i<s.length()){
					ans = Math.max(ans, findLongestSubstring(s.substring(i,j), k));
				}
				i = i+j+1;
			}
			j++;
		}
		if(i!=j && i<s.length() && j<s.length()) {
			System.out.println(i +" "+j);
			ans = Math.max(ans, findLongestSubstring(s.substring(i,j), k));
		}
		return ans;
	}
	
	//Variation subsequence
	private static int findLongestSusequence(String s, int k) {
		if (k == 0) {
			return 0;
		}
		int ans = 0;
		Map<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if(countMap.containsKey(s.charAt(i))) {
				countMap.put(s.charAt(i), countMap.get(s.charAt(i))+1);
			} else {
				countMap.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if(countMap.get(s.charAt(i)) >=k) {
				System.out.print(s.charAt(i));
				ans++;
			}
		}
		
		return ans;
	}

}
