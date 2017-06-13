package leetcode;

/*
 Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree. 
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0
				|| inorder.length == 0)
			return null;
		TreeNode root;
		int n = inorder.length - 1;
		root = buildTreeAux(preorder, inorder, 0, n, 0, n);
		return root;
	}

	TreeNode buildTreeAux(int[] preorder, int[] inorder, int ps, int pe,
			int is, int ie) {
		TreeNode root = new TreeNode(preorder[ps]);

		int i = is;
		while (inorder[i] != preorder[ps]) {
			i++;
		}

		if (i - 1 >= is)
			root.left = buildTreeAux(preorder, inorder, ps + 1, ps + i - is,
					is, i - 1);
		if (i + 1 <= ie)
			root.right = buildTreeAux(preorder, inorder, ps + i - is + 1, pe,
					i + 1, ie);

		return root;

	}
}

// preorder的首位是root i-is是左枝长度, inorder的i+1 和i-1是左右枝的分界