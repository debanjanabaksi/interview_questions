package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * IMPORTANT - THIS HAS A BUG CHECK IT LATER
 */
public class PairOfPalindromes {

	static List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		List<String> vect = Arrays.asList("geekf", "geeks", "or", "keeg", "abc", "bc");
		//List<String> vect1 = Arrays.asList("abcd","dcba","lls","s","sssll");
		//"abcd","dcba","lls","s","sssll"

		if (checkPalindromePairs(vect) == true) {
			System.out.println("Yes");
			for(List<Integer> l : result ) {
				for(int i : l ) {
					System.out.print(vect.get(i)+" ");
				}
				System.out.println();
			}
		}
		else {
			System.out.println("No");
		}
	}

	static class TrieNode {
		TrieNode[] children = new TrieNode[26];
		List<Integer> pos = new ArrayList<>();;
		boolean isLeaf;
		int id;

		TrieNode() {
			isLeaf = false;
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
		}
	}

//	static boolean isPalindrome(String key, int i , int len) {
//		while (i < len) {
//			if (key.charAt(i) != key.charAt(len)) {
//				return false;
//			}
//			i++;
//			len--;
//		}
//		return true;
//	}

//	static void insert(TrieNode root, String key, int id) {
//		if(root == null) {
//			return;
//		}
//		TrieNode pCrawl = root;
//		for (int i = 0; i < key.length(); i++) {
//			int index = key.charAt(i) - 'a';
//			if (pCrawl.children[index] == null) {
//				pCrawl.children[index] = new TrieNode();
//			}
//			// If word is palindrome till this level
//			if (isPalindrome(key, 0, i)) {
//				// store id of word at this level (id is position of word in array)
//				pCrawl.pos.add(id);
//
//			}
//			pCrawl = pCrawl.children[index];
//		}
//		pCrawl.pos.add(id);
//		pCrawl.id = id;
//		pCrawl.isLeaf = true;
//	}

//	static void search(TrieNode root, String key, int id) {
//		TrieNode pCrawl = root;
//		for (int i = 0; i < key.length(); i++) {
//			int index = key.charAt(i) - 'a';
//			if (pCrawl.id >= 0 && pCrawl.id != i && isPalindrome(key, i, key.length()-1)) {
//				List<Integer> l = new ArrayList<>();
//				l.add(id);
//				l.add(pCrawl.id);
//				result.add(l);
//			}
//			if (pCrawl.children[index] == null) {
//				return;
//			}
//			pCrawl = pCrawl.children[index];
//		}
//		for (int i : pCrawl.pos) {
//			if(i==id) {
//				continue;
//			}
//			List<Integer> l = new ArrayList<>();
//			l.add(id);
//			l.add(i);
//			result.add(l);
//		}
//	}
	
	static boolean isPalindrome(String str, int i, int len) { 
        // compare each character from starting 
        // with its corresponding character from last 
        while (i < len) { 
            if (str.charAt(i) != str.charAt(len)) 
                return false; 
  
            i++; 
            len--; 
        } 
        return true; 
    } 
	
	static void insert(TrieNode root, String key, int id) { 
        TrieNode pCrawl = root; 
  
        // Start traversing word from the last 
        for (int level = key.length() - 1; level >= 0; level--) { 
            // If it is not available in Trie, then 
            // store it 
            int index = key.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
  
            // If current word is palindrome till this 
            // level, store index of current word. 
            if (isPalindrome(key, 0, level)) 
                (pCrawl.pos).add(id); 
  
            pCrawl = pCrawl.children[index]; 
        } 
        pCrawl.id = id; 
        pCrawl.pos.add(id); 
  
        // mark last node as leaf 
        pCrawl.isLeaf = true; 
    } 
	
	static void search(TrieNode root, String key, int id) { 
        TrieNode pCrawl = root; 
        for (int level = 0; level < key.length(); level++) { 
            int index = key.charAt(level) - 'a'; 
  
            // If it is present also check upto which index 
            // it is palindrome 
            if (pCrawl.id >= 0 && pCrawl.id != id 
                    && isPalindrome(key, level, key.length() - 1)) { 
                List<Integer> l = new ArrayList<>(); 
                l.add(id); 
                l.add(pCrawl.id); 
                result.add(l); 
            } 
  
            // If not present then return 
            if (pCrawl.children[index] == null) 
                return; 
  
            pCrawl = pCrawl.children[index]; 
        } 
  
        for (int i : pCrawl.pos) { 
            if (i == id) 
                continue; 
            List<Integer> l = new ArrayList<>(); 
            l.add(id); 
            l.add(i); 
            result.add(l); 
        } 
    } 

	static boolean checkPalindromePairs(List<String> keys) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < keys.size(); i++) {
			insert(root, keys.get(i), i);
		}
		for (int i = 0; i < keys.size(); i++) {
			search(root, keys.get(i), i);
		}
		if (!result.isEmpty()) {
			return true;
		}
		return false;
	}
}
