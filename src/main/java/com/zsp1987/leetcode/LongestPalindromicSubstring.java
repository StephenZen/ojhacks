package com.zsp1987.leetcode;

/*
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 */

public class LongestPalindromicSubstring {

	String preProcess(String s) {
		// convert abc to ^#a#b#c#$
		int n = s.length();
		if (n == 0)
			return "^$";
		StringBuilder ret = new StringBuilder();
		ret.append("^");
		for (int i = 0; i < n; i++)
			ret.append("#").append(s.substring(i, i + 1));

		ret.append("#$");
		return ret.toString();
	}

	String longestPalindrome(String s) {
		String t = preProcess(s);
		int n = t.length();
		int[] P = new int[n];
		int C = 0, R = 0; // center and righter
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i; // equals to i' = C - (i-C)
			P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;

			// Attempt to expand palindrome centered at i
			while (t.charAt(i + 1 + P[i]) == t.charAt(i - 1 - P[i]))
				P[i]++;

			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}

		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}

		return s.substring((centerIndex - 1 - maxLen) / 2,
				(centerIndex - 1 - maxLen) / 2 + maxLen);
	}
}

/*
 * (Manacher’s Algorithm) see evernote part II
 * dp 也�?�以�?� cost 是 时间O(n^2) 空间O(n^2)
 * 推导公�?是 P(i,j) = P(i+1, j-1) + 2 ( if S(i) = S(j);
 * �?始�?�件是 P(i,i) = 1 和 P(i, i+1) = 2 if( S(i) = S(i+1));
 */
