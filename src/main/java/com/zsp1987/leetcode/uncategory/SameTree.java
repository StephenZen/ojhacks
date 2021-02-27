package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

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

// 递归 �??历 检查值和左�?�节点
