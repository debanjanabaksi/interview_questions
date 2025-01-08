package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// This is not from leetcode. Its a google interview question
public class ShufflePlaylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] songs1 = {"a","a","b","b","c","c","d","d","e","e","e"};
		ArrayList<String> songs = new ArrayList<String>();
		songs.addAll(Arrays.asList(songs1));
		for(String song : songs1) {
			System.out.print(song + " ");
		}
		System.out.println();
		ArrayDeque<String> shuffledSongs = shuffle(songs);
		
		for(String song : shuffledSongs) {
			System.out.print(song + " ");
		}
		
		String[] songs2 = {"a","b","a","b","a","d","d","d","e","e","e"};
		ArrayList<String> songs22 = new ArrayList<String>();
		songs22.addAll(Arrays.asList(songs2));
		System.out.println();
		for(String song : songs22) {
			System.out.print(song + " ");
		}
		System.out.println();
		ArrayDeque<String> shuffledSongs2 = shuffle(songs22);
		
		for(String song : shuffledSongs2) {
			System.out.print(song + " ");
		}
		
		String[] songs3 = {"a","b","b","b","b","d","d","d","e","e","e"};
		ArrayList<String> songs23 = new ArrayList<String>();
		songs23.addAll(Arrays.asList(songs3));
		System.out.println();
		for(String song : songs23) {
			System.out.print(song + " ");
		}
		System.out.println();
		ArrayDeque<String> shuffledSongs3 = shuffle(songs23);
		
		for(String song : shuffledSongs3) {
			System.out.print(song + " ");
		}
	}
	
	public static class Artist {
		public String name;
		public String title;
		public List<String> songs;
		public String identifier;
		
		public Artist(String artistName) {
			name = artistName;
			identifier = name.substring(0,1);
		}
	}
	
	public static  ArrayDeque<String> shuffle(ArrayList<String> playList) 
	{	
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		ArrayDeque<String> shuffledSongs = new ArrayDeque<String>();
		shuffledSongs.add(playList.remove(0));
		int index = 0;
		while(index != playList.size()) {
		
			if(shuffledSongs.peekLast().equals(playList.get(index))) {
				indexes.add(index);
				index++;
				continue;
			}
			else {
				shuffledSongs.add(playList.get(index));
				index++;
			}
		}
		List<Integer> leftOvers = new ArrayList<Integer>();
//		System.out.println("remaining");
//		for(int printing : indexes) {
//			System.out.print(playList.get(printing) + " ");
//		}
//		System.out.println();
		for(int i = 0 ; i < indexes.size(); i++) {
			while(i+1 < indexes.size() && indexes.get(i) == indexes.get(i+1)+1 ) {
				
				
					leftOvers.add(indexes.get(i));
					continue;
				
				
			}
			
			int playIndex = indexes.get(i);
			shuffledSongs.add(playList.get(playIndex));
		}
		
		//System.out.println();
		if(leftOvers.size()>0) {
			//System.out.println("still remaining");
//			for(int printagain : leftOvers) {
//				System.out.print(playList.get(printagain) + " ");
//			}
			for(int extra : leftOvers) {
				shuffledSongs.add(playList.get(extra));
			}
		}
		
		return shuffledSongs;
	}
	
//	private static void addToList(ArrayList<String> playList, ArrayDeque<String> shuffledSongs, int index) {
//		System.out.println("Adding ..." +playList.size() + " index "+ index);
//		shuffledSongs.add(playList.remove(index));
//	}
}
