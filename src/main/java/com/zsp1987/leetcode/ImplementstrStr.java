package com.zsp1987.leetcode;

/*
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;
		if (haystack.length() == 0)
			return -1;

		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length())
				break;
			if (haystack.substring(i, i + needle.length()).equals(needle))
				return i;

		}
		return -1;

	}
}

// �?能对比 string == ""