package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return result;
		List<TreeNode> nextList = new ArrayList<TreeNode>();
		boolean reverse = false;
		nextList.add(root);
		while (nextList.size() != 0) {
			List<TreeNode> curList = nextList;
			List<Integer> list = new ArrayList<Integer>();
			for (TreeNode node : curList) {
				list.add(node.val);
			}
			result.add(list);
			nextList = new ArrayList<TreeNode>();
			if (reverse) {
				for (int i = curList.size() - 1; i >= 0; i--) {
					TreeNode node = curList.get(i);
					if (node.left != null)
						nextList.add(node.left);
					if (node.right != null)
						nextList.add(node.right);
				}
				reverse = false;
			} else {
				for (int i = curList.size() - 1; i >= 0; i--) {
					TreeNode node = curList.get(i);
					if (node.right != null)
						nextList.add(node.right);
					if (node.left != null)
						nextList.add(node.left);
				}
				reverse = true;
			}

		}

		return result;

	}
}

// 根�?�层是�?�为空判断终止�?�件, 用flag标记顺�?, 选择从左往�?�还是从�?�往左.