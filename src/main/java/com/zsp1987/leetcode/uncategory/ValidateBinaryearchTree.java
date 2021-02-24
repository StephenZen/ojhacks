package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

public class ValidateBinaryearchTree {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null)
			return true;
		boolean leftCheck;
		boolean rightCheck;
		if (root.left == null) {
			leftCheck = true;
		} else {
			if (root.val <= root.left.val || root.left.val < min
					&& min != Integer.MIN_VALUE)
				leftCheck = false;
			else
				leftCheck = isValidBST(root.left, min, root.val - 1);
		}

		if (root.right == null) {
			rightCheck = true;
		} else {
			if (root.val >= root.right.val || root.right.val > max
					&& max != Integer.MAX_VALUE)
				rightCheck = false;
			else
				rightCheck = isValidBST(root.right, root.val + 1, max);
		}

		return leftCheck & rightCheck;
	}
}

// 递归检查左�?�