package com.zsp1987.leetcode.uncategory;

import java.util.LinkedList;

import com.zsp1987.leetcode.datatype.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		LinkedList<TreeLinkNode> A = new LinkedList<TreeLinkNode>();
		A.push(root);
		makeTree(A);
	}

	void makeTree(LinkedList<TreeLinkNode> A) {
		if (A.isEmpty())
			return;
		LinkedList<TreeLinkNode> nextA = new LinkedList<TreeLinkNode>();
		TreeLinkNode cur = null;
		TreeLinkNode pre = null;
		while (!A.isEmpty()) {
			cur = A.remove();
			if (cur.left != null)
				nextA.add(cur.left);
			if (cur.right != null)
				nextA.add(cur.right);
			if (pre != null)
				pre.next = cur;
			pre = cur;
		}
		if (pre != null)
			pre.next = null;
		makeTree(nextA);
	}
}

// 跟1一样的�?路 多个左�?�节点的判断.