package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		return findPath(0, root, sum);
	}

	boolean findPath(int pre, TreeNode node, int sum) {
		if (node.left == null & node.right == null) {
			if (pre + node.val == sum)
				return true;
			else
				return false;
		} else {
			boolean left = false;
			boolean right = false;
			if (node.left != null)
				left = findPath(pre + node.val, node.left, sum);
			if (node.right != null)
				right = findPath(pre + node.val, node.right, sum);

			return (left | right);
		}
	}
}

// 递归调用 dfs �?留parent的sum值 到�?�节点判定, 返回左�?��?的结果的或值