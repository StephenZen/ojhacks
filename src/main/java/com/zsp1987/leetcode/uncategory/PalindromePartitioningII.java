package com.zsp1987.leetcode.uncategory;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return the minimum cuts needed for a palindrome partitioning of s.

 For example, given s = "aab",
 Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut. 
 */

public class PalindromePartitioningII {
	public int minCut(String s) {

		if (s == null || s.length() < 2)
			return 0;
		int n = s.length();
		int[] D = new int[n + 1]; // dp for cut
		boolean[][] P = new boolean[n][n]; // dp for palindrome
		for (int i = 0; i <= n; i++) {
			D[i] = n - i;			// initialize to maxium cut
		}					
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}

		return D[0] - 1;

	}
}

// �?��?DP 一个dp用�?�储存cut数 一个dp用�?�储存回文
// D[i] 区间[i,n] 中最少的cut 数
// P[i][j] 为 i,j段是�?�为回文
// D[i] = Math.min(D[i], D[j+1]+1);