package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		subsets(root, list, 0, sum);
		return result;

	}

	void subsets(TreeNode node, List<Integer> list, int cursum, int sum) {
		List<Integer> listN = new ArrayList<Integer>(list);
		listN.add(node.val);
		cursum += node.val;
		if (node.left == null && node.right == null) {
			if (cursum == sum) {
				List<Integer> newList = new ArrayList<Integer>(listN);
				result.add(newList);
			}
			return;
		} else {
			if (node.left != null)
				subsets(node.left, listN, cursum, sum);
			if (node.right != null)
				subsets(node.right, listN, cursum, sum);
		}
	}
}

// 跟pathsum 一样的�?路dfs�??历 �?�?�点�?层多加一个列表�?存当�?队列