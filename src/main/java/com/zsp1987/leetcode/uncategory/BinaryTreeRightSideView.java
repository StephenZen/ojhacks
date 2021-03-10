package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode<Integer> root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		LinkedList<TreeNode<Integer>> cur = new LinkedList<>();
		cur.addLast(root);
		while (cur.size() != 0) {
			ret.add(cur.getLast().val);
			LinkedList<TreeNode<Integer>> next = new LinkedList<>();
			for (TreeNode<Integer> node : cur) {
				if (node.left != null)
					next.addLast(node.left);
				if (node.right != null)
					next.addLast(node.right);
			}
			cur = next;
		}
		return ret;
	}
}

// 一层一层扫 总是�?�进先出 直到有一层为空
// 注�? 如果用linkedlist的push(到头部 = addFirst()), 迭代list时候 是用pop的顺�?的...
