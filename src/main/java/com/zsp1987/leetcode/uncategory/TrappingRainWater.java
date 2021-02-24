package com.zsp1987.leetcode.uncategory;

/*
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrappingRainWater {
	public int trap(int[] A) {
		int n = A.length;
		if (n == 0)
			return 0;
		int i = 0;
		int j = n - 1;
		int result = 0;
		int max = A[i]; // current max height
		int imax = A[i];
		int jmax = A[j];
		while (i < j) {
			if (max == A[i]) {
				if (max < A[j]) {
					max = A[j];
					jmax = A[j];
				} else {
					if (A[j] > jmax) {
						jmax = A[j];
					} else {
						result += jmax - A[j];
					}
					j--;
				}
			} else {
				if (max < A[i]) {
					max = A[i];
					imax = A[i];
				} else {
					if (A[i] > imax) {
						imax = A[i];
					} else {
						result += imax - A[i];
					}
					i++;
				}

			}

		}
		return result;
	}
}

// �?断维�?一个最高值 从两边夹逼