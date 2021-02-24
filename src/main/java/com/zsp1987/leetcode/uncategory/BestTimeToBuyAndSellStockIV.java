package com.zsp1987.leetcode.uncategory;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.
 */

public class BestTimeToBuyAndSellStockIV {

	public int maxProfit(int k, int[] prices) {
		if (prices.length == 0)
			return 0;
		if (k >= prices.length)
			return solveMaxProfit(prices); // k is larger than operaitons

		int[] local = new int[k + 1]; 
		int[] global = new int[k + 1];

		for (int i = 0; i < prices.length - 1; i++) {
			int diff = prices[i + 1] - prices[i];
			for (int j = k; j >= 1; --j) {
				local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j]
						+ diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}

		return global[k];

	}

	int solveMaxProfit(int[] prices) {
		int ret = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				ret += prices[i] - prices[i - 1];
			}
		}
		return ret;
	}
}

//入股k大于天数 按照stock2的�?路 �?于天数, 跟stock3一样的�?路
//i是天数 , j是次数
//当�?到达第i天最多进行j次交易，最好的利润是多少（global[i][j]），
//当�?到达第i天最多进行j次交易，并且最�?�一次交易在当天�?�出的最好的利润是多少（local[i][j])
//local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
//global[i][j]=max(local[i][j], global[i-1][j])，
//i�?�以用滚动数组去掉