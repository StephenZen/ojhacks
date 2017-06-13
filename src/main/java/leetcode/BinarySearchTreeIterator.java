package leetcode;

/*
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 
 Your BSTIterator will be called like this: BSTIterator i = new
 BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

import java.util.LinkedList;

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

// 构建的时候用inorde(但是从右向左) travel将node push到栈中
// hashnext就检查栈的空 next就pop