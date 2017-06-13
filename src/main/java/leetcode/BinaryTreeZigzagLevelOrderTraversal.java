package leetcode;

/*
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7

 return its zigzag level order traversal as:

 [
 [3],
 [20,9],
 [15,7]
 ]

 */
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return result;
		List<TreeNode> nextList = new ArrayList<TreeNode>();
		boolean reverse = false;
		nextList.add(root);
		while (nextList.size() != 0) {
			List<TreeNode> curList = nextList;
			List<Integer> list = new ArrayList<Integer>();
			for (TreeNode node : curList) {
				list.add(node.val);
			}
			result.add(list);
			nextList = new ArrayList<TreeNode>();
			if (reverse) {
				for (int i = curList.size() - 1; i >= 0; i--) {
					TreeNode node = curList.get(i);
					if (node.left != null)
						nextList.add(node.left);
					if (node.right != null)
						nextList.add(node.right);
				}
				reverse = false;
			} else {
				for (int i = curList.size() - 1; i >= 0; i--) {
					TreeNode node = curList.get(i);
					if (node.right != null)
						nextList.add(node.right);
					if (node.left != null)
						nextList.add(node.left);
				}
				reverse = true;
			}

		}

		return result;

	}
}

// 根据层是否为空判断终止条件, 用flag标记顺序, 选择从左往右还是从右往左.