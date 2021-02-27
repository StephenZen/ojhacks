package com.zsp1987.leetcode.uncategory;

/*
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s.length() <= 1)
			return s;
		int center = (s.length() - 1) / 2;
		String res = "";
		for (int i = center; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				if ((res = check1(s, i, i + 1)) != null)
					return res;
			}
			if ((res = check1(s, i, i)) != null)
				return res;

		}
		return res;
	}

	private String check1(String s, int l, int r) {
		int i = 1;
		for (; l - i >= 0; i++) {
			if (s.charAt(l - i) != s.charAt(r + i))
				break;
		}

		if (l - i >= 0)
			return null;
		StringBuilder sb = new StringBuilder(s.substring(r + i));
		sb.reverse();
		return sb + s;
	}
}

// 从字符串中间�?置开始 �?�左延伸 对比两边字符是�?�相等
// 如果能延伸到左头 将�?�边剩余的字符串逆�? 贴到左头便�?�
// 注�?区分 aba 和 abba的情况
