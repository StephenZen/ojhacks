package leetcode;

/*
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a 
 binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */

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

// 递归调用 算出左枝右枝的高度, 如果高度差超过2的直接return负数, 如果有负数, 理解向上传递, 最后判断根节点是否是负数