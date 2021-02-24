package com.zsp1987.leetcode.uncategory;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

public class ZigZagConversion {

	public String convert(String s, int nRows) {
		int len = s.length();
		if (len < nRows || nRows == 1)
			return s;
		char[] ret = new char[len];
		int step = 2 * (nRows - 1);
		int count = 0;
		for (int i = 0; i < nRows; i++) {
			int interval = step - i * 2;
			for (int j = i; j < len; j += step) {
				ret[count] = s.charAt(j);
				count++;
				if (interval < step && interval > 0 && j + interval < len
						&& count < len) {
					ret[count] = s.charAt(j + interval);
					count++;
				}
			}
		}
		return new String(ret);
	}

	public String convertOld(String s, int nRows) {
		int len = s.length();
		if (len < nRows || nRows == 1)
			return s;
		char[][] ret = new char[nRows][s.length()];

		boolean downflag = true;
		int r = 0; // row
		int c = 0; // column
		int i = 0; // index

		while (i < s.length()) {
			char curChar = s.charAt(i);
			if (downflag == false) {
				if (r == 0) {
					ret[r][c] = curChar;
					downflag = true;
					r++;
				} else {
					ret[r][c] = curChar;
					c++;
					r--;
				}
			} else {
				if (r == nRows - 1) {
					ret[r][c] = curChar;
					downflag = false;
					c++;
					r--;
				} else {
					ret[r][c] = curChar;
					r++;
				}
			}
			i++;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < nRows; j++) {
			sb.append(getString(ret[j]));
		}
		return sb.toString();
	}

	String getString(char[] chars) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != '\u0000')
				sb.append(chars[i]);
		}
		return sb.toString();
	}

}

/*
 * 算出一个Zip循环的间隔, 除了首尾, 中间的行都有两个值,�?始值和�?始值加interval的值
 * 直接输出string
 * 
 * 旧�?路: 创建zig字符串对应的2纬数组 ，然�?�按照Zip的规则�?新读出字符串
 */
