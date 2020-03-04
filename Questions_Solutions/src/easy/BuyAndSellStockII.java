package easy;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 *
 */

public class BuyAndSellStockII {

	public static void main(String[] args) {
		int[] prices1 = {7, 1, 5, 3, 6, 4};
		int[] prices2 = {1, 2, 3, 4, 5};
		int[] prices3 = {7, 6, 4, 3, 1};

		System.out.println(findProfit(prices1));
		System.out.println(findProfit(prices2));
		System.out.println(findProfit(prices3));

	}
	
	private static int findProfit(int[] price) {
		
		int profit = 0;
		for(int i =1; i<price.length; i++) {
			if(price[i]>price[i-1]) {
				profit += price[i]-price[i-1];
			}
		}
		return profit;
	}

}
