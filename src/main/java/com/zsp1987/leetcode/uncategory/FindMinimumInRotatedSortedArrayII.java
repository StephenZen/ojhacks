package com.zsp1987.leetcode.uncategory;

/*
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */

public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] nums) {

		if (nums.length == 0)
			return -1;
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int m = (s + e) / 2;
			if (nums[s] == nums[m]) {			// 从start �?�?到 mid
				if (nums[m] > nums[e]) {
					s = m + 1;
				} else {						// 尾部也都是�?�?
					e--;
				}
			} else if (nums[s] < nums[m]) {
				if (nums[s] >= nums[e]) {		// 从e�?到s都是递增, 所以最�?值肯定在�?�侧
					s = m + 1;
				} else {
					return nums[s];				// 刚好转折
				}
			} else {							// start大于中值, 但�?能确定是�?是中值就是最�?值的开始 所以start + 1; 
				s++;
				e = m;
			}
		}
		return nums[s];
	}
}

// �?点还是跟中值比较 判定最�?值所在区间
