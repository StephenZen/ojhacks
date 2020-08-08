package com.zsp1987.leetcode;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int n = A.length;
		if (n <= 0)
			return -1;
		int l = 0;
		int r = n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (A[mid] == target)
				return mid;
			else {
				if (A[l] <= A[mid]) {
					if (target > A[mid])
						l = mid + 1;
					else {
						if (target >= A[l])
							r = mid - 1;
						else
							l = mid + 1;
					}
				} else {
					if (target < A[mid])
						r = mid - 1;
					else {
						if (target <= A[r])
							l = mid + 1;
						else
							r = mid - 1;
					}
				}
			}
		}

		return -1;
	}
}

// 还是binary search 多次考虑递增区间
