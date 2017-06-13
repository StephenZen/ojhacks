package leetcode;

/*
 Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */

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

// postorder的最后一位肯定是root, (i-is) 是左枝长度, inorder的root的-1是左枝 +1是右枝.