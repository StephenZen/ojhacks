package leetcode;

/*
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,

 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---

 You should return [1, 3, 4]. 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		if (root == null)
			return ret;
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		cur.addLast(root);
		while (cur.size() != 0) {
			ret.add(cur.getLast().val);
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			for (TreeNode node : cur) {
				if (node.left != null)
					next.addLast(node.left);
				if (node.right != null)
					next.addLast(node.right);
			}
			cur = next;
		}
		return ret;
	}
}

// 一层一层扫 总是后进先出 直到有一层为空
// 注意 如果用linkedlist的push(到头部 = addFirst()), 迭代list时候 是用pop的顺序的...
