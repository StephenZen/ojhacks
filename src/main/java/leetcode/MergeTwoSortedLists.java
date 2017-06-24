package leetcode;

import datatype.ListNode;

/*
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode root = node;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				node.next = l1;
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = l2;
				node = node.next;
				l2 = l2.next;
			}
		}
		while (l1 != null) {
			node.next = l1;
			node = node.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			node.next = l2;
			node = node.next;
			l2 = l2.next;
		}
		return root.next;
	}
}