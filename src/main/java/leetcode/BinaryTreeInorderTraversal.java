package leetcode;

/*
 Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3

 return [1,3,2]. 
 */

import datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

// 递归 中间插入