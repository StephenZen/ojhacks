package com.zsp1987.leetcode.uncategory;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {

		if (prices.length < 2) {
			return 0;
		}

		int[] profiles = new int[prices.length - 1];
		int i = 0;

		for (int j = 0; j < profiles.length; j++) {
			i = i + 1;
			int profile = prices[i] - prices[i - 1];
			profiles[j] = profile;
		}

		int sum = 0;
		for (int j = 0; j < profiles.length; j++) {
			if (profiles[j] >= 0)
				sum += profiles[j];
		}

		return sum;

	}
}

// è§£é¢˜çš„æ€?è·¯æ˜¯å?ªå?‡ä¸?é™? ç¬¬äºŒå¤©çš„é’±å¿…é¡»å¤§äºŽå‰?ä¸€å¤© ç„¶å?Žå…¨æ‰€æœ‰ç¬¦å?ˆæ?¡ä»¶çš„æ€»å’Œ
