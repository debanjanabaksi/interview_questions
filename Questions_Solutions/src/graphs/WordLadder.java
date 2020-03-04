package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Input: Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
start = “TOON”
target = “PLEA”
Output: 7
TOON -> POON –> POIN –> POIE –> PLIE –> PLEE –> PLEA
 * 
 *
 */

public class WordLadder {

	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<>();  
	    wordList.add("poon");  
	    wordList.add("plee");  
	    wordList.add("same");  
	    wordList.add("poie");  
	    wordList.add("plie");  
	    wordList.add("poin");  
	    wordList.add("plea");  
	  
	    String start = "toon";  
	    String target = "plea";  
	  
	    System.out.println(ladderLength(start, target, wordList));  

	}
	
	private static class Node 
	{ 
	    String word; 
	    int len;  // Dis from source/ target?
	    public Node(String word, int len) 
	    { 
	        this.word = word; 
	        this.len = len; 
	    } 
	} 
	
	private static boolean isAdj(String a, String b) {
		int c = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				c++;
			}
		}
		if(c == 1) {
			return true;
		}
		return false;
	}
	private static int ladderLength(String beginWord, String endWord,  
            ArrayList<String> wordList)  {
		
		Queue<Node> q1 = new ArrayDeque<>();
		Queue<Node> q2 = new ArrayDeque<>();
		Map<String, Integer> vis1 = new HashMap<>();
		Map<String, Integer> vis2 = new HashMap<>();
		
		Node beg = new Node(beginWord, 1);
		Node end = new Node(endWord, 1);
		
		q1.add(beg);
		q2.add(end);
		
		vis1.put(beginWord, 1);
		vis2.put(endWord, 1);
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			Node n = q1.poll();
			String w = n.word;
			Node n2 = q2.poll();
			String v = n2.word;
			for (String word : wordList) {
				if (isAdj(w, word) && !vis1.containsKey(word)) {
					vis1.put(word, n.len+1);
					Node temp = new Node(word, n.len+1);
					q1.add(temp);
					if (temp.word.equals(endWord)) {
						return temp.len;
					}
					if (vis2.containsKey(word)) {
						return temp.len + vis2.get(word) -1;
					}
					
					
				}
			}
			
			for (String word : wordList) {
				
				if (isAdj(v, word) && !vis2.containsKey(word)) {
					vis2.put(word, n2.len+1);
					Node temp = new Node(word, n2.len+1);
					q2.add(temp);
					if (temp.word.equals(beginWord)) {
						return temp.len;
					}
					if (vis1.containsKey(word)) {
						return temp.len + vis1.get(word) -1;
					}
					
				}
			}
		}
		return 0;
		
	}

}
