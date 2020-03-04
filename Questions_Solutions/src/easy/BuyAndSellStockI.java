package easy;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

 */
public class BuyAndSellStockI {

	public static void main(String[] args) {
		int[] prices1 = { 7, 1, 5, 3, 6, 4 };
		int[] prices2 = { 7, 6, 4, 3, 1 };
		int[] prices3 = { 3, 3, 5, 0, 0, 3, 1, 4 };

		BuyAndSellStockI buySell = new BuyAndSellStockI();
		System.out.println("Profit is " + buySell.findProfit(prices1));
		System.out.println("Profit is " + buySell.profit(prices1));
		System.out.println("Profit is " + buySell.findProfit(prices2));
		System.out.println("Profit is " + buySell.profit(prices2));
		System.out.println("Profit is " + buySell.findProfit(prices3));
		System.out.println("Profit is " + buySell.profit(prices3));

	}
	
	private int findProfit(int[] price) {
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0; i<price.length; i++) {
			if(price[i]<min) {
				min = price[i];
			} else if(price[i]-min > profit) {
				profit = price[i]-min;
			}
		}
		return profit;
	}

	//Solution 2
	private int profit(int[] price) {
		int min = price[0], result = 0;
		for(int i =1; i<price.length;i++) {
			result = Math.max(result, price[i]-min);
			min = Math.min(min, price[i]);
		}
		return result;
	}
}
