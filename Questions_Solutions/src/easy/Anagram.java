package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Anagram means one string can be made by rearranging the other. Like tea and eat
 *
 *
 */
public class Anagram {
	
	public static void main(String args[]) {
		Anagram ang = new Anagram();
		String str1 = "tea";
		String str2= "eat";
		String str3 =  "anagram";
		String str4 = "nagaram";
		String str5 = "car";
		String str6 = "rat";
		String str7= "abx1-A";
		String str8 = "bx-1aA";
		String str9= "asdf23$";
		String str10 = "fgjy_7U";
		
		System.out.println("Is anagram : "+ ang.isAnagramSorting(str1, str2));
		System.out.println("Is anagram : "+ ang.isAnagramSorting(str3, str4));
		System.out.println("Is anagram : "+ ang.isAnagramSorting(str5, str6));
		System.out.println("");
		
		System.out.println("Is anagram : "+ ang.isAnagramHashTable(str1, str2));
		System.out.println("Is anagram : "+ ang.isAnagramHashTable(str3, str4));
		System.out.println("Is anagram : "+ ang.isAnagramHashTable(str5, str6));
		System.out.println("");
		
		System.out.println("Is anagram : "+ ang.isAnagramUnicodeCharacters(str1, str2));
		System.out.println("Is anagram : "+ ang.isAnagramUnicodeCharacters(str3, str4));
		System.out.println("Is anagram : "+ ang.isAnagramUnicodeCharacters(str5, str6));
		System.out.println("Is anagram : "+ ang.isAnagramUnicodeCharacters(str7, str8));
		System.out.println("Is anagram : "+ ang.isAnagramUnicodeCharacters(str9, str10));
		
	}
	//Use java sorting. Time complexity O(nlogn) Sorting algorithms take O(nlogn) assuming maybe heap sort
	//O(n) for comparing.  O(nlogn) + O(n) = O(nlogn) since this is greater
	// Space complexity is O(1) assuming sorting algorithm takes O(1). Assuming it isheapsort
	//assume small letters only
	//Note that in Java, toCharArray() makes a copy of the string so it costs O(n) extra space, but we ignore this for complexity analysis because:
	//It is a language dependent detail.
	//It depends on how the function is designed. For example, the function parameter types can be changed to char[].
	private boolean isAnagramSorting(String str1, String str2) {
		System.out.println("isAnagramSorting");
		System.out.println(str1);
		System.out.println(str2);
		if (str1.length()!=str2.length()) {
			return false;
		}
		char[] s = str1.toCharArray();
		char[] t = str2.toCharArray();
		Arrays.sort(s);
		Arrays.sort(t);
		if(Arrays.equals(s, t)) {
			return true;
		}
		return false;
	}
	
	//Time complexity O(n). Space complexity O(1) since constant hashtable
	//assume small letters only
	private boolean isAnagramHashTable(String str1, String str2) {
		System.out.println("isAnagramHashTable");
		System.out.println(str1);
		System.out.println(str2);
		if (str1.length()!=str2.length()) {
			//System.out.println("Length not equal");
			return false;
		}
		int n = str1.length();
		
		int[] table = new int[26];
	
		for (int i = 0; i < n; i++) {
			table[str1.charAt(i)-'a']++;
			table[str2.charAt(i)-'a']--;
		}
		for (int i=0; i<table.length;i++) {
			if(table[i]!=0) {
				//System.out.println("Extra character "+"at "+ i+ "number is : "+table[i]);
				return false;
			}
		}
		return true;
	}
	
	//Time complexity O(n). We iterate 3 times for n (strings are of equal length and hashmap will have as many elements)
	//So O(3n). Space complexity is O(n), hashtable has size equal to string size. Assuming hash functions are O(1)
	
	private boolean isAnagramUnicodeCharacters(String str1, String str2) {
		System.out.println("isAnagramUnicodeCharacters");
		System.out.println(str1);
		System.out.println(str2);
		if (str1.length()!=str2.length()) {
			return false;
		} 
		Map<String, Integer> charTable = new HashMap<>();
		int n = str1.length();
		for (int i = 0; i < n; i++) {
			char c= str1.charAt(i);
			if (charTable.get(String.valueOf(c)) == null) {
				charTable.put(String.valueOf(c), 0);
			}
			Integer cnt = charTable.get(String.valueOf(c)); 
			cnt++;
		} 
		for (int i = 0; i < n; i++) {
			char c2= str2.charAt(i);
			if (charTable.get(String.valueOf(c2)) == null) {
				//different character in str2 which was not in str1
				return false;
			}
			Integer count = charTable.get(String.valueOf(c2)); 
			count--;
		}
		
		for (Integer i : charTable.values()) {
			// if both strings are anagrams, there should be equal no. of characters, negative means 
			//extra in str2, positive means extra in str1
			if (i!=0) {
				return false;
			}
		}
		return true;
	}
}
