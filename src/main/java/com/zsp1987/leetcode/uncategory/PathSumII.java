package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode<Integer> root, int sum) {
		if (root == null)
			return result;
		List<Integer> list = new ArrayList<>();
		subsets(root, list, 0, sum);
		return result;

	}

	void subsets(TreeNode<Integer> node, List<Integer> list, int cursum, int sum) {
		List<Integer> listN = new ArrayList<Integer>(list);
		listN.add(node.val);
		cursum += node.val;
		if (node.left == null && node.right == null) {
			if (cursum == sum) {
				List<Integer> newList = new ArrayList<>(listN);
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