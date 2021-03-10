package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {

		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (null == root)
			return result;
		build(root, result, 1);
		Collections.reverse(result);
		return result;

	}

	void build(TreeNode<Integer> node, List<List<Integer>> result, int lvl) {
		if (node == null)
			return;
		if (lvl > result.size()) {
			LinkedList<Integer> lvlResult = new LinkedList<Integer>();
			result.add(lvlResult);
		}
		result.get(lvl - 1).add(node.val);
		build(node.left, result, lvl + 1);
		build(node.right, result, lvl + 1);

	}
}

// 用个递归, 判断当�?层高, 出现新层创建, �?�则�?�出从左往�?�加,跟1的�?维一样,最�?�全局结果的顺�?倒置.