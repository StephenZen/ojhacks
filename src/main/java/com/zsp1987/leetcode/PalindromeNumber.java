package com.zsp1987.leetcode;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * ex. 1001, 121, 123321
 */

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10) {
			div = div * 10;
		}

		while (div > 1) {
			int l = x / div;
			int r = x % 10;
			if (l != r)
				return false;
			else {
				x = x - l * div;
				x = x / 10;
				div = div / 100;
			}
		}

		return true;

	}

}
