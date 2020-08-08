package com.zsp1987.leetcode;

/*
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.

 What is the minimum candies you must give? 
 */

public class Candy {
	public int candy(int[] ratings) {

		int n = ratings.length;
		if (n <= 1)
			return n;

		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			if (i > 0 && ratings[i] > ratings[i - 1])
				ret[i] = ret[i - 1] + 1;
			else
				ret[i] = 1;
		}
		for (int i = n - 1; i >= 1; i--) {
			if (ratings[i - 1] > ratings[i]) {
				ret[i - 1] = Math.max(ret[i] + 1, ret[i - 1]);
			}
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			total += ret[i];
		}
		return total;
	}
}
 
// 正扫一�?? �?障�?�边比左边rating大的 多一个
// �??扫一�?? �?�?左边比�?�边rating大的 一定大于�?�边