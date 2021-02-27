package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		visit(root, list);
		return list;

	}

	public void visit(TreeNode node, List<Integer> list) {

		if (null != node.left) {
			visit(node.left, list);
		}
		list.add(node.val);
		if (null != node.right) {
			visit(node.right, list);
		}

	}
}

// 递归 中间�?�入