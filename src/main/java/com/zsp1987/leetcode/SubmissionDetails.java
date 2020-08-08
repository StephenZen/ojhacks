package com.zsp1987.leetcode;

import com.zsp1987.leetcode.datatype.ListNode;

public class SubmissionDetails {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return null;
		if (n == 0)
			return head;

		ListNode cur = head;
		int count = 1;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}
		cur.next = head;
		n = n % count;
		cur = head;
		int i = 1;
		int j = count - n;
		while (i < j) {
			cur = cur.next;
			i++;
		}

		ListNode result = cur.next;
		cur.next = null;
		return result;
	}
}