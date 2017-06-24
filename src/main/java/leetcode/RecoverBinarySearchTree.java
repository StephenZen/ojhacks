package leetcode;

/*
 Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution? 
 */

import datatype.TreeNode;

public class RecoverBinarySearchTree {
	TreeNode firstElement = null;
	TreeNode secondElement = null;
	TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		// In order traversal to find the two elements
		traverse(root);

		// Swap the values of the two nodes
		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		// Start of "do some business",
		// If first element has not been found, assign it to prevElement (refer
		// to 6 in the example above)
		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		// If first element is found, assign the second element to the root
		// (refer to 2 in the example above)
		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		// End of "do some business"

		traverse(root.right);
	}
}

// dfs 遍历, 发现当前元素比父元素大的时候 说明父元素有问题, 记录两个问题元素, 交换其对应数值