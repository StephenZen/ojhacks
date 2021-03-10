package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
	public ListNode<Integer> sortList(ListNode<Integer> head) {
		if (head == null || head.next == null) // list size == 0 or == 1
			return head;
		ListNode<Integer> fast = head.next.next;
		ListNode<Integer> slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode<Integer> rightStart = sortList(slow.next);
		slow.next = null;
		return merge(sortList(head), rightStart);
	}

	public ListNode<Integer> merge(ListNode<Integer> h1, ListNode<Integer> h2) {
		ListNode<Integer> hn = new ListNode<>(Integer.MIN_VALUE);
		ListNode<Integer> cur = hn;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				cur.next = h1;
				h1 = h1.next;
			} else {
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}
		if (h1 != null)
			cur.next = h1;
		if (h2 != null)
			cur.next = h2;
		return hn.next;
	}
}

// merge sort
// use fast and slow runner to find the middle point of list
// divide list until size 0 or 1
// merge by creating new list