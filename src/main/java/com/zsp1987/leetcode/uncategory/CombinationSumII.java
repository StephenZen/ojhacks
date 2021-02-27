package com.zsp1987.leetcode.uncategory;

/*
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * 
 * All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set
 * is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		if (num == null)
			return result;
		Arrays.sort(num);
		backtrack(num, target, 0, 0);
		return result;
	}

	void backtrack(int[] num, int target, int cursum, int lvl) {
		if (cursum == target) {
			List<Integer> newList = new ArrayList<Integer>(list);
			if (!result.contains(newList)) {
				result.add(newList);
			}
			return;
		} else if (cursum > target || lvl == num.length) {
			return;
		} else {
			list.add(num[lvl]);
			backtrack(num, target, cursum + num[lvl], lvl + 1);
			list.remove(list.size() - 1);
			backtrack(num, target, cursum, lvl + 1);
		}

	}
}

// 标准回溯 跟一的区别是时候加完就进�?