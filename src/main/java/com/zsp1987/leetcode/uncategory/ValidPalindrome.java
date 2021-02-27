package com.zsp1987.leetcode.uncategory;

/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome. 
 */

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		char l, r;
		while (i < j) {
			while (i < j
					&& !(Character.isLetter(s.charAt(i)) || Character.isDigit(s
							.charAt(i)))) {
				i++;
			}
			l = s.charAt(i);
			while (i < j
					&& !(Character.isLetter(s.charAt(j)) || Character.isDigit(s
							.charAt(j)))) {
				j--;
			}
			r = s.charAt(j);
			if (Character.toUpperCase(l) != Character.toUpperCase(r))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

// 两侧夹逼 直到相�?�