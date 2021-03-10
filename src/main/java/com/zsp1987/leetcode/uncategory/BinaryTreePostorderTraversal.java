package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode<Integer> root) {

		LinkedList<TreeNode<Integer>> temp = new LinkedList<>();
		LinkedList<TreeNode<Integer>> rResult = new LinkedList<>();		// reverse result
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		temp.add(root);
		while (temp.size() != 0) {
			TreeNode<Integer> node = temp.pop();
			rResult.push(node);
			if (node.left != null) {
				TreeNode<Integer> nodeL = node.left;
				temp.push(nodeL);
			}
			if (node.right != null) {
				TreeNode<Integer> nodeR = node.right;
				temp.push(nodeR);
			}
		}
		while (0 != rResult.size()) {
			result.add(rResult.pop().val);
		}

		return result;
	}
}

// rResult里存的是顺�?是node->node->right->node->left, 所以最�?�将整个顺�?倒置就是正确的顺�?了