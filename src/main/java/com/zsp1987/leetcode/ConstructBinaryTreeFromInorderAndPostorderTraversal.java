package com.zsp1987.leetcode;

import com.zsp1987.leetcode.datatype.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0)
			return null;
		int n = postorder.length;
		TreeNode root = buildTreeAux(inorder, postorder, 0, n - 1, 0, n - 1);
		return root;

	}

	TreeNode buildTreeAux(int[] inorder, int[] postorder, int is, int ie,
			int ps, int pe) {
		TreeNode root = new TreeNode(postorder[pe]);
		int i = is;
		while (inorder[i] != postorder[pe]) {
			i++;
		}
		if (i - 1 >= is)
			root.left = buildTreeAux(inorder, postorder, is, i - 1, ps, ps
					+ (i - is - 1));
		if (i + 1 <= ie)
			root.right = buildTreeAux(inorder, postorder, i + 1, ie, ps
					+ (i - is), pe - 1);
		return root;

	}
}

// postorderçš„æœ€å?Žä¸€ä½?è‚¯å®šæ˜¯root, (i-is) æ˜¯å·¦æž?é•¿åº¦, inorderçš„rootçš„-1æ˜¯å·¦æž? +1æ˜¯å?³æž?.