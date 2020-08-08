package com.zsp1987.leetcode;

/*
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 */
public class HouseRobberII {
	public int rob(int[] nums) {

		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);

		int[] ret1 = new int[n];
		int[] ret2 = new int[n];

		ret1[0] = nums[0];
		ret1[1] = Math.max(nums[0], nums[1]);
		int m = n - 1; // optimized code by not count in loop condition
		for (int i = 2; i < m; i++) {
			int cur = nums[i];
			ret1[i] = Math.max(ret1[i - 2] + cur, ret1[i - 1]);
		}

		ret2[1] = nums[1];
		ret2[2] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < n; i++) {
			int cur = nums[i];
			ret2[i] = Math.max(ret2[i - 2] + cur, ret2[i - 1]);
		}

		return Math.max(ret1[n - 2], ret2[n - 1]);
	}
}

// 跟rob1 一样的�?路, dp的公�?都是 当�?最大为 ret[n] = Math.max(ret[n -2 ] + nums[n], ret[n-1))
// 唯一的差别是 分两�?情况 一�?是从0开始 �?算最�?�一�?, �?�外一�?是从1开始,算最�?�一�?
// 比较两�?请款的最大值
