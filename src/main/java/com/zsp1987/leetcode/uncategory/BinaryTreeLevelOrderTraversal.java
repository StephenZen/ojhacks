package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		build(result, 0, root);
		return result;

	}

	void build(List<List<Integer>> result, int lvl, TreeNode<Integer> node) {
		int n = result.size();
		List<Integer> lvlList;
		if (lvl > n - 1) {
			lvlList = new ArrayList<Integer>();
			lvlList.add(node.val);
			result.add(lvlList);
		} else {
			lvlList = result.get(lvl);
			lvlList.add(node.val);
		}
		if (node.left != null)
			build(result, lvl + 1, node.left);
		if (node.right != null)
			build(result, lvl + 1, node.right);

	}
}

// �??历�?层 用全局�?��?记录结果 用lvl记录层高 若当�?lvl的层高大于全局�?��?的长度 就生�?新层, �?�则就�?�出当�?lvl对应的列表 往里�?�填充