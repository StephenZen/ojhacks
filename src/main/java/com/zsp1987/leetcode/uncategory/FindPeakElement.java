package com.zsp1987.leetcode.uncategory;

/*
 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 0;
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int m = (s + e) / 2;
			if (s > m - 1) { // two element;
				return nums[s] > nums[e] ? s : e;
			}
			if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1])
				return m;
			else if (nums[m] > nums[m - 1])
				s = m;
			else
				e = m;
		}
		return s;
	}
}

// revised, change from recursive to iterative.
// 就是local maxium
// binary search, process when element are two
// 如果中值比中值加一值�?, �?��?��?�, 因为肯定会�?
// 如果中值比中值�?一�?, �?�左�?�, 因为肯定会�?
