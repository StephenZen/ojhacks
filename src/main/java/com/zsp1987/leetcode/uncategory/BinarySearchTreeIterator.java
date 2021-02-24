package com.zsp1987.leetcode.uncategory;

import java.util.LinkedList;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinarySearchTreeIterator {
	class BSTIterator {
		LinkedList<TreeNode> list;

		public BSTIterator(TreeNode root) {
			this.list = new LinkedList<TreeNode>();
			inordertraversal(this.list, root);
		}

		void inordertraversal(LinkedList<TreeNode> list, TreeNode node) {
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

// 构建的时候用inorde(但是从�?��?�左) travel将node push到栈中
// hashnext就检查栈的空 next就pop