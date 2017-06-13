package leetcode;

/*
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		ArrayList<ListNode> A = new ArrayList<ListNode>();
		ListNode node = head;
		A.add(node);
		while (node.next != null) {
			A.add(node.next);
			node = node.next;
		}
		TreeNode root = buildTree(A);
		return root;
	}

	TreeNode buildTree(List<ListNode> list) {
		int n = list.size();
		TreeNode node;
		if (n >= 3) {
			int mid = n / 2;
			node = new TreeNode(list.get(mid).val);
			node.left = buildTree(list.subList(0, mid));
			node.right = buildTree(list.subList(mid + 1, n));
			return node;
		} else if (n == 2) {
			node = new TreeNode(list.get(1).val);
			node.left = buildTree(list.subList(0, 1));
			return node;
		} else {
			return new TreeNode(list.get(0).val);
		}
	}
}