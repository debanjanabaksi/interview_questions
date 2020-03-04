package medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberByArrangingIntegers {

	public static void main(String[] args) {
		int[]arr = {3, 30, 34, 5, 9};
		
		printNum(arr);


	}
	
	private static void printNum(int[]arr) {
		int n = arr.length;
		String[] str = new String[n];
		for(int i = 0; i<n; i++) {
			str[i] = String.valueOf(arr[i]);
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String order1 = o1+o2;
				String order2 = o2+o1;
				return order2.compareTo(order1);
			}
			
		});
		String strLarge = new String();
		
		for(int i = 0; i<n; i++) {
			strLarge+= str[i];
		}
		
		System.out.println(strLarge);
	}

}
