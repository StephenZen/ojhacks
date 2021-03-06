package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> node = new ListNode<>(0);
		ListNode<Integer> root = node;
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