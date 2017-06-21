package dfs;

/*
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

import datatype.TreeNode;

public class MaximumDepthOfBinaryTree {

	// divide and conquer
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	// traversal
	private int depth;
	public int maxDepthTraversal(TreeNode root)
	{
		depth = 0;
		helper(root, 1);
		return depth;
	}

	private void helper(TreeNode node, int curtDepth) {
		if (node == null) {
			return;
		}
		if (curtDepth > depth) {
			depth = curtDepth;
		}

		helper(node.left, curtDepth + 1);
		helper(node.right, curtDepth + 1);
	}
}