package com.zsp1987.leetcode.binarytree;

import java.util.Stack;
import com.zsp1987.leetcode.annotation.LeetCode;

@LeetCode(114)
public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);

		TreeNode left = root.left;
		TreeNode right = root.right;

		root.left = null;
		root.right = left;

		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}

	public void flattenOld(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
