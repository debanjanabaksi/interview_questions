package hard;

import java.util.ArrayList;
import java.util.List;

//This is a general problem, not a leet code one
/**
 * 0/1 knapsack problem where are
 * you are trying to maximize the total profit of items selected without exceeding the capacity of
 * your knapsack.
 *
 * <p>Time Complexity: O(nW) Space Complexity: O(nW)
 * 
 * Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 

Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

 */
public class KnapsackProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 10;
	    int[] V = {1, 4, 8, 5};
	    int[] W = {3, 3, 5, 6};
	    System.out.println("\n Cost is "+knapsack(capacity, W, V));

	    capacity = 7;
	    V = new int[] {2, 2, 4, 5, 3};
	    W = new int[] {3, 1, 3, 4, 2};
	    System.out.println("\n Cost is "+knapsack(capacity, W, V));

	}
	
	private static int knapsack(int capacity, int[]W, int[]V) {
		int n = W.length;
		if (W == null || V == null || W.length != V.length) {
			return -1;
		}
		int[][] dp = new int[n+1][capacity+1]; // wt vs sack size. +1 for adjusting indexes. Its 1 based too. 0 row and column is all 0
		
		for (int i = 1; i <= n ; i++) {
			int w = W[i-1], v = V[i-1]; // -1 since its we are starting from 1
			for (int j = 1; j <= capacity; j++) {
				// Consider not adding this element to sack
				dp[i][j] = dp[i-1][j]; 
				// Consider including the current element and
		        // see if this would be more profitable
				if (j >= w && dp[i-1][j-w]+v > dp[i][j] )
					dp[i][j] = dp[i-1][j-w]+v;
			}
		}
		int j = capacity;
		// Using the information inside the table we can backtrack and determine
	    // which items were selected during the dynamic programming phase. The idea
	    // is that if DP[i][j] != DP[i-1][j] then the item was selected
		List<Integer> selected = new ArrayList<Integer>();
		for (int i = n; i > 0; i --) {
			if(dp[i][j] != dp[i-1][j]) {
				int index = i-1;
				selected.add(index);
				j -= W[index]; //( since it it was dp[i-1][j-w])
			}
		}
		for(int i = 0; i < selected.size(); i++) {
			System.out.print(W[(selected.get(i))]+ " ");
		}
		
		return dp[n][capacity];
	}

}
