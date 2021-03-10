package com.zsp1987.leetcode.uncategory;

import java.util.LinkedList;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinarySearchTreeIterator {
	class BSTIterator {
		LinkedList<TreeNode<Integer>> list;

		public BSTIterator(TreeNode<Integer> root) {
			this.list = new LinkedList<TreeNode<Integer>>();
			inordertraversal(this.list, root);
		}

		void inordertraversal(LinkedList<TreeNode<Integer>> list, TreeNode<Integer> node) {
			if (node != null) {
				inordertraversal(list, node.right);
				list.push(node);
				inordertraversal(list, node.left);
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !list.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			return list.pop().val;
		}
	}

}