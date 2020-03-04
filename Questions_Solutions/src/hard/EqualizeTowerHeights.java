package hard;

import java.util.Arrays;

public class EqualizeTowerHeights {

	public static void main(String[] args) {
		int h[] = { 1, 2, 3 };
		int cost[] = { 10, 100, 1000 };
		int n = h.length; 
		System.out.println("\nanswer is " +minCost(h, cost, n));
		System.out.println("\n");
		
        System.out.println("\nanswer is " +Bsearch(n, h, cost)); 

	}

	private static long totCost(int[] cost, int h[], int equilizer, int n ) {
		long c = 0;
		for (int i = 0; i < n; i++) {
			c += Math.abs(h[i] - equilizer) * cost[i];
		}
		System.out.print(" "+c);
		return c;
	}

	private static long minCost(int h[], int c[], int n) {
	
		int maxHt = Arrays.stream(h).max().getAsInt();
		System.out.println("\nmax ht "+maxHt);
		long start = 0;
		long end = 1 + maxHt;
		long ans = Long.MAX_VALUE;
		while (end > start) {
			int mid = (int)((start + end) >> 1);
			System.out.println("mid "+mid);
			long bm = (mid > 0) ? totCost(c, h, mid - 1, n) : Long.MAX_VALUE;
			long m = totCost(c, h, mid, n);
			long am = totCost(c, h, mid + 1,n);
			if (ans == m) {
				break;
			}
			ans = Long.min(ans, m);
			if (bm <= m) {
				end = mid;
			} else if (am <= m) {
				start = mid + 1;
			}
		}
		return ans;
	}

	static long costOfOperation(int n, int h[], int cost[], int eq_h) {
// Initialize initial cost to 0 
		long c = 0;

// Adding cost for each tower 
		for (int i = 0; i < n; i++)
			c += Math.abs(h[i] - eq_h) * cost[i];
		System.out.print(" "+c);
		return c;
	}

// Return the minimum possible cost of operation 
// to bring all the towers of different height 
// in height[0..n-1] to same height. 
	static long Bsearch(int n, int h[], int cost[]) {
		int max_h = Arrays.stream(h).max().getAsInt();
		long ans = Long.MAX_VALUE;
		System.out.println("\nmax ht "+max_h);

// Do binary search for minimum cost 
		long high = 1 + max_h;
		long low = 0;
		while (high > low) {
			int mid = (int) ((low + high) >> 1);
			System.out.println("mid "+mid);

// Cost below mid 
			long bm = (mid > 0) ? costOfOperation(n, h, cost, mid - 1) : Long.MAX_VALUE;

// Cost at mid 
			long m = costOfOperation(n, h, cost, mid);

// Cost above mid 
			long am = costOfOperation(n, h, cost, mid + 1);

// Break if the answer becomes equal to 
// minimum cost m 
			if (ans == m)
				break;

// ans should hold the minimum cost of operation 
			ans = Long.min(ans, m);

// Search lower cost 
			if (bm <= m)
				high = mid;

// Search higher cost 
			else if (am <= m)
				low = mid + 1;
		}

		return ans;
	}

}
