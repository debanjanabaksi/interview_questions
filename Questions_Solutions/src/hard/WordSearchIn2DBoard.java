package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIn2DBoard {

	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		char[][]board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		Set<String> wordSet = new HashSet<>();
		wordSet.addAll(Arrays.asList(words));
		wordSearch(board, words,wordSet);
		for(String s : result) {
			System.out.println(s);
		}

	}
	//set of words i.e. wordSet not needed added for checking if set can work in place of trie
	private static void wordSearch(char[][] board, String[] words, Set<String> wordSet) {
		Trie trie = new Trie();
		trie.root = new Trie.TrieNode();
		for(String word : words) {
			Trie.insert(word, trie.root);
		}
		
		int m = board.length;
		int n = board[0].length;
		boolean visited[][] = new boolean[m][n];
		
		for(int i = 0; i <m; i++) {
			for (int j = 0; j<n; j++) {
				dfs(board, "", i,j, trie.root,visited,wordSet);
			}
		}
	}
	
	private static void dfs(char[][]board, String prefix, int i, int j, Trie.TrieNode root, boolean[][] visited, Set<String> wordSet) {
		int m = board.length;
		int n = board[0].length;
		
		if(i<0||j<0||i>=m||j>=n) {
			return;
		}
		
		if(visited[i][j]) {
			return;
		}
		
		String str = prefix+board[i][j];
		//This can be omitted. It does the same things as search just does not check for word completion
		// But its an optimization to prevent further DFS. Even if search for string fails with current str, need to check with neighbours
		//to see if word can be formed. Cant say if !trie.search() return.
		if(!Trie.startsWith(str, root)) {
			return;
		}
		if(Trie.search(str, root)) {
			result.add(str);
		} 
//		if(wordSet.contains(str)) {
//			result.add(str);
//		}
		visited[i][j]= true;
		dfs(board, str, i-1, j, root, visited,wordSet);
		dfs(board, str, i+1, j, root, visited,wordSet);
		dfs(board, str, i, j-1, root, visited,wordSet);
		dfs(board, str, i, j+1, root, visited,wordSet);
		visited[i][j]= false;
	}
}
