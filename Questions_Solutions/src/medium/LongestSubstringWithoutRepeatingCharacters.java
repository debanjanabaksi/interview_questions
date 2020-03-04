package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String str1 = "abcabcbb";
		String str2 = "bbbbb";
		String str3 = "pwwkew";
		System.out.println("Longest Substring Without Repeating Characters for "+str1+ " is "+longestSubs(str1)+" "+longestSubsMap(str1) );
		System.out.println("Longest Substring Without Repeating Characters for "+str2+ " is "+longestSubs(str2)+" "+longestSubsMap(str2) );
		System.out.println("Longest Substring Without Repeating Characters for "+str3+ " is "+longestSubs(str3)+" "+longestSubsMap(str3) );
	}
	private static int longestSubs(String str) {
		int n = str.length(), ans =0;
		Set<Character> set = new HashSet<>();
		int i=0, j=0;
		while(i<n && j<n) {
			if(!set.contains(str.charAt(j))) {
				set.add(str.charAt(j));
				j++;
				ans = Math.max(ans, j-i);
			} else {
				set.remove(str.charAt(i));
				i++;
			}
		}
		return ans;
	}
	
	private static int longestSubsMap(String str) {
		int n = str.length(), ans =0;
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0, j=0; j<n;j++) {
			if(map.containsKey(str.charAt(j))) {
				i = Math.max(map.get(str.charAt(j)), i);
				j++;
			} else {
				ans = Math.max(ans, j-i+1);
				map.put(str.charAt(j), j+1);//since this may become i in future and i is starting character/position for next window, we start after repeating char
											//so j+1
				
			}
		}
		return ans;
	}

}
