package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.io.*; 

public class Ambigrams {
	
	public static Map<Character, Character> ambigramChars = new HashMap<Character, Character>();
	public static Set<String> ambigramWords = new HashSet<String>();
	public static void main(String[] args) {
		ambigramChars.put('a', 'e'); // as per question
		ambigramChars.put('b', 'd');
		ambigramChars.put('c', ' ');
		ambigramChars.put('d', 'p'); // as per question else it is a b too
		ambigramChars.put('e', 'a'); // as per question
		ambigramChars.put('f', ' ');
		ambigramChars.put('g', ' ');
		ambigramChars.put('h', 'y');
		ambigramChars.put('i', 'i');
		ambigramChars.put('j', ' ');
		ambigramChars.put('k', ' ');
		ambigramChars.put('l', 'l');
		ambigramChars.put('m', 'w');
		ambigramChars.put('n', 'u');
		ambigramChars.put('o', 'o');
		ambigramChars.put('p', 'd');
		ambigramChars.put('q', 'p');
		ambigramChars.put('r', ' ');
		ambigramChars.put('s', 's');
		ambigramChars.put('t', 't');
		ambigramChars.put('u', 'n');
		ambigramChars.put('v', ' ');
		ambigramChars.put('w', 'm');
		ambigramChars.put('x', 'x');
		ambigramChars.put('y', 'h');
		ambigramChars.put('z', ' ');
		
		String input1 = "yeah";
		String input2 = "swims";
		
		System.out.println("Is "+input1 +" an ambigram?" + checkAmbigram(input1));
		System.out.println("Is "+input2 +" an ambigram?" + checkAmbigram(input2));
		
		char oldLetter = ambigramChars.get('a');
		oldLetter = 'a';
		ambigramChars.put('a', oldLetter);
		System.out.println("Is "+input1 +" an ambigram?" + checkAmbigram(input1));
//		char prev = ambigramChars.get('m');
//		prev = 'v';
//		ambigramChars.put('m', prev);
		
		
		ambigramWords.add("pip");
		ambigramWords.add("did");
		ambigramWords.add("wow");
		ambigramWords.add("mom");
		
		
		System.out.println("Ambigram of "+"pip is present - " + (returnAmbigramTwin("pip").isEmpty() ? "no" : "yes. It is " +returnAmbigramTwin("pip")));
		System.out.println("Ambigram of "+"mom is present -" + (returnAmbigramTwin("mom").isEmpty() ? "no" : "yes. It is " +returnAmbigramTwin("mom")));
		System.out.println("Ambigram of "+"dad is present - " + (returnAmbigramTwin("dad").isEmpty() ? "no" : "yes. It is " +returnAmbigramTwin("dad")));
		
		System.out.println("Trying streams");
		readFromStream();
	}
	
	private static boolean checkAmbigram(String word) {
		StringBuilder newWord = new StringBuilder();
		
		findRotatedWord(word, newWord);
		System.out.println("Rotated word is "+ newWord);
		
		if (newWord.toString().equals(word)) {
			return true;
		}
		
		return false;
	}

	private static void findRotatedWord(String word, StringBuilder newWord) {
		for (int i = word.length()-1; i >= 0; i-- ) {
			char rotatedLetter = ambigramChars.get(word.charAt(i));
			//System.out.print("letter : " +rotatedLetter + " ");
			if (rotatedLetter != ' ') {
				newWord.append(String.valueOf(rotatedLetter));
				//System.out.println(" word :  "+ newWord + " ");
			}
		}
	}
	
	
	private static String returnAmbigramTwin(String word) {
		StringBuilder newWord = new StringBuilder();
		
		findRotatedWord(word, newWord);
		
		 if (ambigramWords.contains(newWord.toString()) ) {
			 return newWord.toString();
		 }
		 
		 return "";
	}
	
	private static void readFromStream() {
		//FileInputStream file = new FileInputStream("test.txt");
//		String[] teststrings = {"dad", "wow", "mom", "yeah", "swims"};
//		Stream<String> input = Arrays.asList(teststrings).stream();
//		
		Stream<String> input = ambigramWords.stream();
		input.limit(5).forEach(word -> {
			String twin = returnAmbigramTwin(word);
			if (twin.isEmpty()) {
				System.out.println("Does not exist");
			}
			else {
				System.out.println(twin);
			}
		});
		
	}
	
//	// A list of words is too big to store in memory. write a java code to pull it from a generator or stream
//	private void testStream() {
//		String[] teststrings = {"dad", "wow", "mom", "yeah", "swims"};
//		Stream s = Stream.generate(new Supplier<String>() {
//			int limit = 5;
//			int count = 0;
//			@Override
//			public String get() {
//				if( count < limit )
//					return teststrings[count++];
//				else 
//					return null;
//			}});
//	}
}
