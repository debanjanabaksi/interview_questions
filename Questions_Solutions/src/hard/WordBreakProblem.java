package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hard.Trie.TrieNode;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. Return all such possible sentences. Assume no
 * duplicates in dictionary, same word can be used twice in results
 * 
 * 
 *
 */
public class WordBreakProblem {

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		Set<String> dictionary = new HashSet<>();
		dictionary.addAll(wordDict);
		boolean result;

		System.out.println(canWordBeBroken(s, dictionary));

		System.out.println(canWordBeBrokenRecurse(s, dictionary));

		System.out.println(canWordBeBrokenDP(s, dictionary));
		
		System.out.println(canWordBeBrokenTrie(s,dictionary));

		wordBreak(s, dictionary, " ");
		wordBreakTrie(s, dictionary, " ");
		
		
	}

	private static boolean canWordBeBroken(String str, Set<String> dictionary) {
		int n = str.length();
		int[] pos = new int[n + 1];// init array to size+1 so that all indices of the string can be iterated over.
		Arrays.fill(pos, -1);
		pos[0] = 0;
		for (int i = 0; i <= n; i++) {
			if (pos[i] != -1) {
				for (int j = i + 1; j <= n; j++) {
					String sub = str.substring(i, j);
					// System.out.println(sub);
					if (dictionary.contains(sub)) {
						System.out.print(sub + " ");
						pos[j] = i;
					}
				}
			}
		}
		return pos[str.length()] != -1;
	}

	private static boolean canWordBeBrokenRecurse(String str, Set<String> dictionary) {
		int n = str.length();
		if (n == 0) {
			return true;
		}
		for (int i = 1; i <= n; i++) {
			String sub = str.substring(0, i);
			// System.out.println(sub);
			if (dictionary.contains(sub) && canWordBeBrokenRecurse(str.substring(i, n), dictionary)) {
				return true;
			}
		}
		return false;
	}

	private static boolean canWordBeBrokenDP(String str, Set<String> dictionary) {
		int n = str.length();
		if (n == 0) {
			return true;
		}
		boolean t[] = new boolean[n + 1];
		// t[0] = true;
		for (int i = 1; i <= n; i++) {
			if (!t[i] && dictionary.contains(str.substring(0, i))) {
				t[i] = true;
			}
			if (t[i]) {
				if (i == n) {
					return true;
				}
				for (int j = i + 1; j <= n; j++) {
					if (!t[j] && dictionary.contains(str.substring(i, j))) {
						t[j] = true;
					}
					if (j == n && t[j]) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static void wordBreak(String str, Set<String> dictionary, String result) {
		int n = str.length();
		for (int i = 1; i <= n; i++) {
			String prefix = str.substring(0, i);
			if (dictionary.contains(prefix)) {
				if (i == n) {
					result = result + prefix;
					System.out.println(result);
					return;
				}
				// carry fwd whatever was obtained from last recursion call and add current
				// computed prefix
				wordBreak(str.substring(i, n), dictionary, result + prefix + " ");
			}
		}
	}
	
	private static boolean canWordBeBrokenTrie(String str, Set<String> dictionary) {
		 TrieNode root = new TrieNode();
		 root = addToTrie(dictionary, root);
		 int n = str.length();
		 if (n == 0)  
			 return true; 
		 for(int i = 1; i<=n; i++) {
			 String prefix = str.substring(0,i);
			 if(Trie.search(prefix, root)) {
				 if(canWordBeBrokenTrie(str.substring(i,n), dictionary)) {
					 return true;
				 }
				 
			 }
		 }
		
		return false;
	}
	

	private static void wordBreakTrie(String str, Set<String> dictionary, String result) {
		 TrieNode root = new TrieNode();
		 root = addToTrie(dictionary, root);
		 int n = str.length();
		
		 for(int i = 1; i<=n; i++) {
			 String prefix = str.substring(0,i);
			 if(Trie.search(prefix, root)) {
				 if(i==n) {
				    result = result + prefix;
					System.out.println(result);
					return;
				 }
				 wordBreakTrie(str.substring(i, n),dictionary, result + prefix + " ");
			 }
			 
		 }
	 }

	private static TrieNode addToTrie(Set<String> dictionary, TrieNode root) {
		for(String s : dictionary) {
			root = Trie.insert(s, root);
		}
		return root;
	}
}
