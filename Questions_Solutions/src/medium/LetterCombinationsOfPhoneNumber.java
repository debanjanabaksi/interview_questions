package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	static Map<Integer, String> phoneMap = new HashMap<>();

	static {
		phoneMap.put(2,"abc");
		phoneMap.put(3,"def");
		phoneMap.put(4,"ghi");
		phoneMap.put(5,"jkl");
		phoneMap.put(6,"mno");
		phoneMap.put(7,"pqrs");
		phoneMap.put(8,"tuv");
		phoneMap.put(9,"wxyz");
	}
	
	public static void main(String[] args) {
		
		String digits1 = "23";
		String digits2 = "234";
		System.out.println("Input is "+ digits1+ " combinations are : ");
		printCombinations(digits1);
		System.out.println("\n\nInput is "+ digits2+ " combinations are : ");
		printCombinations(digits2);
	}
	
	private static void printCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.isEmpty()) {
			System.out.println("Input not present");
		}
		
		findCombinations(result, digits, 0, "");
		
		for(String s : result) {
			System.out.println(s);
		}
	}
	
	private static void findCombinations(List<String> result, String digits, int index, String currentCombo) {
		// max array index is always 1 less than length of string, so when we have processed last element, index is length-1,
		// after incrementing it, it is = length, so after final recursive call, index will be = length.
		if(index == digits.length()) {
			result.add(currentCombo);
			return;
		}
		
		int currDigit = digits.charAt(index)-'0';
		if(currDigit == 1 || currDigit == 9) {
			return;
		}
		String letters = phoneMap.get(currDigit);
		for(int i=0; i< letters.length(); i++) {
			findCombinations(result, digits, index+1, currentCombo+letters.charAt(i));
		}
	}

}
