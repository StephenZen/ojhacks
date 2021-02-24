package com.zsp1987.leetcode.uncategory;

/*
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class IntegerToRoman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		int m = num / 1000;
		while (m > 0) {
			sb.append('M');
			num -= 1000;
			m--;
		}
		int cm = num / 900;
		if (cm > 0) {
			sb.append("CM");
			num -= 900;
		}
		int d = num / 500;
		if (d > 0) {
			sb.append('D');
			num -= 500;
		}

		int cd = num / 400;
		if (cd > 0) {
			sb.append("CD");
			num -= 400;
		}

		int c = num / 100;
		while (c > 0) {
			sb.append('C');
			num -= 100;
			c--;
		}

		int xc = num / 90;
		if (xc > 0) {
			sb.append("XC");
			num -= 90;
		}
		int l = num / 50;
		if (l > 0) {
			sb.append('L');
			num -= 50;
		}

		int xl = num / 40;
		if (xl > 0) {
			sb.append("XL");
			num -= 40;
		}

		int x = num / 10;
		while (x > 0) {
			sb.append('X');
			num -= 10;
			x--;
		}

		int ix = num / 9;
		if (ix > 0) {
			sb.append("IX");
			num -= 9;
		}
		int v = num / 5;
		if (v > 0) {
			sb.append('V');
			num -= 5;
		}

		int iv = num / 4;
		if (iv > 0) {
			sb.append("IV");
			num -= 4;
		}

		int i = num / 1;
		while (i > 0) {
			sb.append('I');
			num -= 1;
			i--;
		}

		return sb.toString();

	}
}

/*
 * 一直除 9 和 4是特例
 */
