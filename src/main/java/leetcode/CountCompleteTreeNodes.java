package leetcode;

/*
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
	int height(TreeNode root) {
		return root == null ? -1 : 1 + height(root.left);
	}

	public int countNodes(TreeNode root) {
		int h = height(root);
		return h < 0 ? 0 : height(root.right) == h - 1 ? 
				(1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
	}
}

// recursive左枝算层高
// 如果root的层高和root的右节点层高差1, root的左枝是完整的, root加左枝个数刚好等于2^h
// 如果root的层高和root的右节点高度差超过1, 则右枝是完整的(但高度为h-2), root加右枝的个数刚好等于2^(h-1)
