package hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] arr = {100, 4, 200, 1, 3, 2};
		int ans  = longestConsecutiveSequence(arr);
		System.out.println(ans);

	}
	
	private static int longestConsecutiveSequence(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i< arr.length; i++) {
			set.add(arr[i]);
		}
		int current = 0;
		int longest = 0;
		int maxSequence = 0;
		for (int num : set) {
			//System.out.print(num+ " ");
			if(!set.contains(num-1)) {
				//System.out.print(num-1+ " not present ");
				current = num;
				longest = 1;
				while(set.contains(current+1)) {
				//	System.out.print((current+1)+ " present ");
					current++;
					longest++;
				}
			}
			maxSequence = Math.max(maxSequence, longest);
			//System.out.println((maxSequence)+ " current max seq ");
		}
		return maxSequence;
	}

}
