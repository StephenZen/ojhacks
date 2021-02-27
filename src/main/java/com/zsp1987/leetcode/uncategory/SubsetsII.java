package com.zsp1987.leetcode.uncategory;

/*
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	private List<Integer> list = new ArrayList<Integer>();
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsetsWithDup(int[] num) {
		if (num == null)
			return result;
		Arrays.sort(num);
		subsets(num, 0);
		return result;
	}

	private void subsets(int[] S, int index) {
		if (index == S.length) {
			ArrayList<Integer> newList = new ArrayList<Integer>(list);
			if (!result.contains(newList)) {
				result.add(newList);
			}
			return;
		}
		list.add(S[index]);
		subsets(S, index + 1);
		list.remove(list.size() - 1);
		subsets(S, index + 1);

	}
}

// 就是回溯