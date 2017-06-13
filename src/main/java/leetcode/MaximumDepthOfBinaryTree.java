package leetcode;

/*
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return getDepth(root, 1);

	}

	public int getDepth(TreeNode node, int depth) {
		int leftDepth = depth;
		int rightDepth = depth;
		if (null != node.left)
			leftDepth = getDepth(node.left, leftDepth + 1);
		if (null != node.right)
			rightDepth = getDepth(node.right, rightDepth + 1);
		return leftDepth > rightDepth ? leftDepth : rightDepth;

	}
}

// dfs遍历树 输出左右枝的最大值