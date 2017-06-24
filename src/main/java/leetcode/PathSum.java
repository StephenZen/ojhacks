package leetcode;

/*
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

import datatype.TreeNode;

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

// 递归调用 dfs 保留parent的sum值 到叶节点判定, 返回左右枝的结果的或值