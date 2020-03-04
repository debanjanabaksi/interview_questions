package hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hard.Trie.TrieNode;

public class Trie {
	
	private static final int ALPHABET_LENGTH = 26;
	
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_LENGTH];
		boolean isEndOfWord;
		//can hold a value like string/int which can be empty/null. Not using value here just default "" string.
		String value = "";
		
		TrieNode() {
			isEndOfWord = false;
			for(int i = 0; i < ALPHABET_LENGTH; i++) {
				children[i]=  null;
			}
		}
	}
	
	static TrieNode root;
	public static TrieNode insert(String key, TrieNode root) {
		TrieNode pCrawl = root;
		int n = key.length();
		for(int i = 0; i<n; i++) {
			int index = key.charAt(i)-'a';
			if(pCrawl.children[index]== null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfWord = true;
		return root;
	}
	
	public static boolean search(String key, TrieNode root) {
		TrieNode pCrawl = root;
		int n = key.length();
		for(int i = 0; i < n; i++) {
			int index = key.charAt(i) - 'a';
			if(pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl!=null && pCrawl.isEndOfWord) ;
	}
	
	public static boolean startsWith(String key, TrieNode root) {
		TrieNode pCrawl = root;
		int n = key.length();
		for(int i = 0; i < n; i++) {
			int index = key.charAt(i) - 'a';
			if(pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}
		return true;
	}
	
	public static void main(String[] args) {
		// Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
        root = new TrieNode(); 
        
//    	String s = "catsanddog";
//		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//		Set<String> dictionary = new HashSet<>();
//		dictionary.addAll(wordDict);
//	
//		
//		System.out.println(canWordBeBrokenTrie(s,dictionary));
		
       
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
            insert(keys[i], root); 
       
        // Search for different keys 
        if(search("the", root) == true) 
            System.out.println("the --- " + output[1]); 
        else System.out.println("the --- " + output[0]); 
          
        if(search("these", root) == true) 
            System.out.println("these --- " + output[1]); 
        else System.out.println("these --- " + output[0]); 
          
        if(search("their", root) == true) 
            System.out.println("their --- " + output[1]); 
        else System.out.println("their --- " + output[0]); 
          
        if(search("thaw", root) == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
         

	}
	
	private static boolean canWordBeBrokenTrie(String str, Set<String> dictionary) {
		System.out.println("canWordBeBrokenTrie "+str);
		 addToTrie(dictionary, root);
		 int n = str.length();
		 if (n == 0)  
			 return true; 
		 for(int i = 1; i<=n; i++) {
			 if(Trie.search(str.substring(0,i), root)) {
				 if(canWordBeBrokenTrie(str.substring(i,n), dictionary)) {
					 return true;
				 }
				 
			 }
		 }
		
		return false;
	}

	private static void addToTrie(Set<String> dictionary, TrieNode root) {
		for(String s : dictionary) {
			root = Trie.insert(s, root);
		}
		
	}

}
