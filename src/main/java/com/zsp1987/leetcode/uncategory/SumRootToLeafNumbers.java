package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

/*
 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3

 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25. 
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		int sum = 0;
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return sum;
		build(result, 0, root);
		for (int i : result) {
			sum += i;
		}
		return sum;
	}

	void build(List<Integer> result, int pre, TreeNode node) {
		if (node.left == null && node.right == null) {
			result.add(pre * 10 + node.val);
			return;
		} else {

			if (node.left != null) {
				build(result, pre * 10 + node.val, node.left);
			}
			if (node.right != null) {
				build(result, pre * 10 + node.val, node.right);
			}
		}
	}
}

// dfs记录根到�?�的路径, 将数字记录到列表中, 最�?�相加