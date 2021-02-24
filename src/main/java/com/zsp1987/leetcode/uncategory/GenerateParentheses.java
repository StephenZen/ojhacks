package com.zsp1987.leetcode.uncategory;

/*
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {

		char[] result = new char[2 * n];
		int pos = 0;
		int l = n; // left number of left parentheses
		int r = n; // left number of right parentheses
		List<String> resultList = new ArrayList<String>();
		proc(result, pos, l, r, n, resultList);
		return resultList;

	}

	void proc(char[] result, int pos, int l, int r, int n,
			List<String> resultList) {
		if (pos == 2 * n) { // final point!!
			String vaild = new String(result);
			if (!resultList.contains(vaild)) {
				resultList.add(vaild);
			}
		} else {
			char[] l_result = result.clone();
			char[] r_result = result.clone();

			if (l != 0) {
				l_result[pos] = '(';
				proc(l_result, pos + 1, l - 1, r, n, resultList);
			}

			if (check(l, r)) { // right parentheses cannot have more than left
				r_result[pos] = ')';
				proc(r_result, pos + 1, l, r - 1, n, resultList);
			}

		}
	}

	boolean check(int l, int r) {
		return l < r ? true : false;
	}
}