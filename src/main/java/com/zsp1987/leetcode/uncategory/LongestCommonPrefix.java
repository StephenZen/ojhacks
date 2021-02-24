package com.zsp1987.leetcode.uncategory;

/*
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		char[] result = strs[0].toCharArray();
		int length = strs[0].length();

		for (int i = 1; i < strs.length; i++) {
			length = strs[i].length() < length ? strs[i].length() : length;
			for (int j = 0; j < length; j++) {
				if (result[j] != strs[i].charAt(j)) {
					length = j;
					break;
				}
			}
			if (length == 0)
				return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(result[i]);
		}
		return sb.toString();

	}
}

/*
 * �?个对比， 一个全局�?��?维护最长长度
 */
