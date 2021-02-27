package com.zsp1987.leetcode.uncategory;

/*
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3]. 
 */

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] A) {
		int n = A.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int cur = A[0];
		int count = 1;
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			if (A[i] != cur) {
				cur = A[i];
				A[count] = cur;
				count++;
				flag = false;
			} else if (flag == false) {
				A[count] = cur;
				count++;
				flag = true;
			}
		}
		return count;
	}
}

// �?超过两次