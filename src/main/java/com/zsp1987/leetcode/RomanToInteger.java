package com.zsp1987.leetcode;

/*
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	public int romanToInt(String s) {
		int n = s.length();
		int total = 0;
		int max = 0;
		int temp = 0;
		for (int i = n - 1; i > -1; i--) {
			if ((temp = parseRoman(s.charAt(i))) >= max) {
				max = temp;
				total += temp;
			} else {
				total -= temp;
			}
		}
		return total;
	}

	int parseRoman(char s) {
		switch (s) {
		case 'M':
			return 1000;
		case 'D':
			return 500;
		case 'C':
			return 100;
		case 'L':
			return 50;
		case 'X':
			return 10;
		case 'V':
			return 5;
		case 'I':
			return 1;
		}

		return 0;
	}
}
