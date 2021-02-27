package com.zsp1987.leetcode.uncategory;


/*
 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB 

 Credits:
 Special thanks to @ifanchu for adding this problem and creating all test cases
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int r = n % 26;
			if (r == 0) {
				n = n - 26;
				r = 25;
			} else {
				r = r - 1;
			}
			n = n / 26;
			sb.insert(0, (char) ('A' + r));

		}
		return sb.toString();
	}
}

// 当刚好整除26时, �?�高�?借1,
