package com.zsp1987.leetcode.uncategory;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (n == 0 || k == 0)
			return result;

		build(result, new ArrayList<Integer>(), 1, n, k);
		return result;
	}

	void build(List<List<Integer>> result, ArrayList<Integer> cur, int lower,
			int n, int k) {
		if (cur.size() == k) {
			result.add(cur);
			return;
		}
		if (lower > n) {
			return;
		}
		for (int i = lower; i <= n; i++) {
			ArrayList<Integer> curN = new ArrayList<Integer>(cur);
			curN.add(i);
			build(result, curN, i + 1, n, k);
		}
	}
}

// bt 注�?排�?就好了