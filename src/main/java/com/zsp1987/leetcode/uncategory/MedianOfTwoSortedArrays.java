package com.zsp1987.leetcode.uncategory;

/*
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 */

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;
		if (total % 2 != 0)
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
		else {
			double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);
			double y = findKth(A, 0, m - 1, B, 0, n - 1, total / 2 + 1);
			return (double) (x + y) / 2;
		}

	}

	public int findKth(int[] A, int aL, int aR, int[] B, int bL, int bR, int k) {

		int m = aR - aL + 1;
		int n = bR - bL + 1;

		if (m > n)
			return findKth(B, bL, bR, A, aL, aR, k);
		if (m == 0)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[aL], B[bL]);

		int partA = Math.min(k / 2, m);
		int partB = k - partA;

		if (A[aL + partA - 1] < B[bL + partB - 1]) {
			return findKth(A, aL + partA, aR, B, bL, bR, k - partA);
		} else if (A[aL + partA - 1] > B[bL + partB - 1]) {
			return findKth(A, aL, aR, B, bL + partB, bR, k - partB);
		} else {
			return A[aL + partA - 1];
		}
	}
}

/*
 * 两个数组�?��?�中， 比较中的大�?
 * 求第k的�?路是二分查找
 */
