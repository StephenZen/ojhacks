package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5 
 */
public class RemoveLinkedListElements {
	public ListNode<Integer> removeElements(ListNode<Integer> head, int val) {
		if (head == null)
			return null;
		ListNode<Integer> start = head;
		ListNode<Integer> cur = head;
		while (cur != null && cur.val == val) {
			cur = cur.next;
			start = cur;
		}
		if (cur == null)
			return null;
		ListNode<Integer> pre = cur;
		cur = cur.next;
		while (cur != null) {
			if (cur.val != val) {
				pre.next = cur;
				pre = cur;
			}
			cur = cur.next;
		}
		pre.next = cur;

		return start;
	}
}

