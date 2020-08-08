package com.zsp1987.leetcode;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			if (s.length() == 0)
				return true;
			else
				return false;
		}

		else if (p.length() == 1) {
			if (s.length() < 1)
				return false;
			else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
		}

		else if (p.charAt(1) != '*') {
			if (s.length() < 1)
				return false;
			else if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
		} else {
			if (isMatch(s, p.substring(2))) { // coz x. can be a empty string
				return true;
			}

			int i = 0;
			while (i < s.length() // recursive call isValid
					&& (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}

	}


}
