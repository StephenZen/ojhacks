package com.zsp1987.leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.
 */

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0)
			return 0;
		int lowest = prices[0];
		int curMax;
		int maxMax = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] < lowest) {
				lowest = prices[i];
			} else {
				curMax = prices[i] - lowest;
				if (curMax > maxMax)
					maxMax = curMax;
			}
		}
		return maxMax;
	}
}

// 三个�?��? 当�?最低值, 当�?最高值, 全局最高值, 当�?值超过当�?最低或最高 更新, 并对比全局最高值
