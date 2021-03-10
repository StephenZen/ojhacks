package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeMaximumPathSum {
	int maxValue;

	public int maxPathSum(TreeNode<Integer> root) {
		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));		//get left side max branch
		int right = Math.max(0, maxPathDown(node.right));	//get right side max branch
		maxValue = Math.max(maxValue, left + right + node.val);	//compare to max value and update
		return Math.max(left, right) + node.val;			//only return max to upper level.
	}
}

// dfs 全局�?��?�?�控制最大值 超过最大值就记录 注�? 如果左�?��?的加和是负值的�?就用�?弃并�?�0