package com.zsp1987.leetcode;

/*
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28 
 */

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int n = s.length();
		int count = 0;
		if (n == 0)
			return count;
		for (int i = 0; i < n; i++) {
			count += (s.charAt(i) - 64) * Math.pow(26, n - 1 - i);
		}
		return count;
	}
}

// 呃.. �?评论了 26进制