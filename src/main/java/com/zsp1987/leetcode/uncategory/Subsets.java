package com.zsp1987.leetcode.uncategory;

/*
 Given a set of distinct integers, S, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.

 For example,
 If S = [1,2,3], a solution is: 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	private List<Integer> list = new ArrayList<Integer>();
	private List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsets(int[] S) {
		if (S == null)
			return result;
		Arrays.sort(S);
		subsets(S, 0);
		return result;
	}

	private void subsets(int[] S, int index) {
		if (index == S.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		subsets(S, index + 1);
		list.add(S[index]);
		subsets(S, index + 1);
		list.remove(list.size() - 1);
	}
}

// dp 在加新元素就进下层