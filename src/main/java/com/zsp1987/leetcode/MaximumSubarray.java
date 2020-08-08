package com.zsp1987.leetcode;

/*
 Find the contiguous subarray within an array (containing at least one number)
 which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 */
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public int maxSubArrayOld(int[] A) {
		int n = A.length;
		int currentMax = Integer.MIN_VALUE;
		int maxMax = Integer.MIN_VALUE;
		int current = 0;

		for (int i = 0; i < n; i++) {
			currentMax = Integer.MIN_VALUE;
			current = 0;
			for (int j = 0; i + j < n; j++) {
				current += A[i + j];
				if (current > currentMax)
					currentMax = current;
				if (current > maxMax)
					maxMax = current;
				if (current < 0)
					break;
			}
		}
		return maxMax;
	}
}
