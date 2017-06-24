package leetcode;

/*
 Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3

 return [3,2,1].

 Note: Recursive solution is trivial, could you do it iteratively?
 */

import datatype.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {

		LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
		LinkedList<TreeNode> rResult = new LinkedList<TreeNode>();		// reverse result
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		temp.add(root);
		while (temp.size() != 0) {
			TreeNode node = temp.pop();
			rResult.push(node);
			if (node.left != null) {
				TreeNode nodeL = node.left;
				temp.push(nodeL);
			}
			if (node.right != null) {
				TreeNode nodeR = node.right;
				temp.push(nodeR);
			}
		}
		while (0 != rResult.size()) {
			result.add(rResult.pop().val);
		}

		return result;
	}
}

// rResult里存的是顺序是node->node->right->node->left, 所以最后将整个顺序倒置就是正确的顺序了