package com.zsp1987.leetcode.dp;

import java.util.Arrays;

/*
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 */
public class HouseRobber {
	public int rob(int[] nums) { // bottom up
		if (nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);
		int[] ret = new int[n];
		ret[0] = nums[0];
		ret[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			int cur = nums[i];
			ret[i] = Math.max(ret[i - 2] + cur, ret[i - 1]);
		}
		return ret[n - 1];
	}


	private int[] memo;
	public int robDp(int[] nums) {  // top down
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return dp(nums, 0);
	}

	private int dp(int[] nums, int start) {
		if (start >= nums.length) {
			return 0;
		}

		if (memo[start] != -1) return memo[start];

		int res = Math.max(
				dp(nums, start + 1),
				nums[start] + dp(nums, start +2)
		);
		memo[start] = res;
		return res;
	}
}

