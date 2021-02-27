package com.zsp1987.leetcode.uncategory;
/*
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 */

public class ReverseInteger {
	public int reverse(int x) {
		int ret = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = ret * 10 + tail;
			if ((newResult - tail) / 10 != ret) {
				return 0;	// avoid number too large and overflow (like 123242123211)
			}
			ret = newResult;
			x = x / 10;
		}

		return ret;
	}
}
