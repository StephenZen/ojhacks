package leetcode;

/*
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.

 For example,
 Given the following binary tree,

 1
 /  \
 2    3
 / \    \
 4   5    7

 After calling your function, the tree should look like:

 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL

 */
import java.util.LinkedList;

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

// 跟1一样的思路 多个左右节点的判断.