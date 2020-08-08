package com.zsp1987.leetcode;

import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

	public int threeSumClosest2(int[] num, int target) {

		int close = Integer.MAX_VALUE;
		int ret = 0;
		int n = num.length;
		if (num == null || num.length == 0)
			return 0;
		if (num.length <= 3) {

			for (int i = 0; i < n; i++) {
				ret += num[i];
			}
			return ret;
		}

		Arrays.sort(num);
		for (int i = 0; i < n - 2; i++) {

			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int temp = num[i] + num[j] + num[k];
				if (temp == target)
					return temp;
				else {
					if (Math.abs(temp - target) < close) {
						close = Math.abs(temp - target);
						ret = temp;
					}
					if (temp > target)
						k--;
					if (temp < target)
						j++;
				}
			}

		}

		return ret;

	}

}

/*
 * �?�照3sum 选定一个点 �?�外两个点夹击
 */
