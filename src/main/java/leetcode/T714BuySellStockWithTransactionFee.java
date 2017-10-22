package leetcode;

public class T714BuySellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int[] hold = new int[prices.length];
		int[] empty = new int[prices.length];
		
		hold[0] = -prices[0];
		for(int i = 1;i < prices.length; i++) {
			hold[i] = Math.max(hold[i - 1], empty[i - 1] - prices[i] );
			empty[i] =  Math.max(empty[i - 1], hold[i - 1] + prices[i] - fee);
		}
		return empty[prices.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new T714BuySellStockWithTransactionFee().maxProfit(new int[] { 1, 7, 2, 5, 3, 9}, 2));
	}
}
