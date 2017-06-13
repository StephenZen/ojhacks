package leetcode;

/*
 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6

 The flattened tree should look like:

 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 */
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}

			p = p.right;
		}
	}
}

// 右枝先压栈 左枝变右枝 无左枝出栈 