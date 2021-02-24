package com.zsp1987.leetcode.uncategory;

import java.util.Stack;

import com.zsp1987.leetcode.datatype.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
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
}

// å?³æž?å…ˆåŽ‹æ ˆ å·¦æž?å?˜å?³æž? æ— å·¦æž?å‡ºæ ˆ 