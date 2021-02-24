package com.zsp1987.leetcode.uncategory;

/*
 Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	List<List<String>> result = new ArrayList<List<String>>();
	List<String> list = new ArrayList<String>();

	public List<List<String>> partition(String s) {
		if (s == null)
			return result;
		int n = s.length();
		build(s, 0, n);
		return result;
	}

	void build(String s, int lvl, int n) {
		if (lvl == n) {
			List<String> newlist = new ArrayList<String>(list);
			result.add(newlist);
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			String sub = s.substring(0, i);
			if (checkPalindrome(sub)) {
				list.add(sub);
				build(s.substring(i), lvl + i, n);
				list.remove(list.size() - 1);
			}
		}
	}

	boolean checkPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			else {
				i++;
				j--;
			}
		}
		return true;

	}
}

// backtracking 检查�?个字符是�?�是回文, 是则加, 加完记得消除