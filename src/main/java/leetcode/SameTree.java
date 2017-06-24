package leetcode;

/*
 Given two binary trees, write a function to isValid if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value. 
 */

import datatype.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (null == p && null == q)
			return true;
		if (null == p && null != q)
			return false;
		if (null != p && null == q)
			return false;
		boolean value = (p.val == q.val);
		boolean left = true;
		boolean right = true;
		left = isSameTree(p.left, q.left);
		right = isSameTree(p.right, q.right);
		return value && left && right;
	}

}

// 递归 遍历 检查值和左右节点
