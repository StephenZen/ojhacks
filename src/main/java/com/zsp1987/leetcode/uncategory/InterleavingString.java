package com.zsp1987.leetcode.uncategory;

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null)
			return false;
		int n1 = s1.length();
		int n2 = s2.length();
		int n3 = s3.length();

		if (n3 != n1 + n2)
			return false;

		boolean[][] result = new boolean[n1 + 1][n2 + 1];
		result[0][0] = true;
		for (int i = 1; i < n1 + 1; i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1)) {
				result[i][0] = true;
			} else
				break;
		}
		for (int j = 1; j < n2 + 1; j++) {
			if (s3.charAt(j - 1) == s2.charAt(j - 1)) {
				result[0][j] = true;
			} else
				break;
		}

		for (int i = 1; i < n1 + 1; i++) {
			char c1 = s1.charAt(i - 1);
			for (int j = 1; j < n2 + 1; j++) {
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(i + j - 1);
				if (c3 == c1)
					result[i][j] |= result[i - 1][j];
				if (c3 == c2)
					result[i][j] |= result[i][j - 1];
			}
		}

		return result[n1][n2];

	}
}

// dp 构建矩阵 result[i][j] 等于当�?长度为i+j的string 跟s1的�?i 和s2的�?j的string match