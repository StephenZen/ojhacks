package com.zsp1987.leetcode.uncategory;

import java.util.TreeSet;

/*
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {

			Integer floor = values.floor(nums[i] + t);
			Integer ceil = values.ceiling(nums[i] - t);
			if ((floor != null && floor >= nums[i])
					|| (ceil != null && ceil <= nums[i])) {
				return true;
			}

			values.add(nums[i]);
			if (i >= k) {
				values.remove(nums[i - k]);
			}
		}

		return false;
	}
}

// 用一个treeset�?�维护一个排�?的set
// 到一个�?置 如果当�?set中有在t上下范围的数就找到了
// �?�则加入当�?数 并移除此数�?k�?置的那个数 �?�?set的选择范围
