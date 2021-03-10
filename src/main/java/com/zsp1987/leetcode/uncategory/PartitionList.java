package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

public class PartitionList {
	public ListNode<Integer> partition(ListNode<Integer> head, int x) {
		if (head == null)
			return head;
		ListNode<Integer> cur, left, right, lefthead, righthead;

		cur = head;
		left = null;
		right = null;
		lefthead = null;
		righthead = null;

		while (cur != null) {
			if (cur.val >= x) {
				if (righthead == null) {
					righthead = cur;
					right = cur;
				} else {
					right.next = cur;
					right = cur;
				}

			} else {
				if (lefthead == null) {
					lefthead = cur;
					left = cur;
				} else {
					left.next = cur;
					left = cur;
				}
			}
			cur = cur.next;
		}

		if (right != null)
			right.next = null; // clear rightmost

		if (left != null) {
			left.next = righthead;
			return lefthead;
		} else {
			return righthead;
		}

	}
}
