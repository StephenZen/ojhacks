package com.zsp1987.leetcode.linkedlist;

import com.zsp1987.leetcode.annotation.LeetCode;

@LeetCode(206)
public class ReverseLinkedList {

	// iteratively
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}

		return prev;
	}

	ListNode tail;

	// recursive
	public ListNode reverseListR(ListNode head) {
		if (head == null)
			return null;
		tail = head;
		reverse(head);
		return tail;

	}

	ListNode reverse(ListNode head) {
		if (head.next != null) {
			tail = head.next;
			reverse(head.next).next = head;
			head.next = null;
		}
		return head;
	}



	public class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
