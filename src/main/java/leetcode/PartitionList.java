package leetcode;

/*
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */

import datatype.ListNode;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode cur, left, right, lefthead, righthead;

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

//建立两个子链 左边小 右边大 最走连接起来两个链表