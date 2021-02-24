package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (getHeight(root) == -1)
			return false;

		return true;
	}

	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int left = getHeight(root.left);
		int right = getHeight(root.right);

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;

	}
}

// 递归调用 算出左�?�?��?的高度, 如果高度差超过2的直接return负数, 如果有负数, �?�解�?�上传递, 最�?�判断根节点是�?�是负数