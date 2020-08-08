package com.zsp1987.leetcode;
/*
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */

import com.zsp1987.leetcode.datatype.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		int curSum, carry = 0;
		ListNode cur, pre, result;
		ListNode cur1 = l1;
		ListNode cur2 = l2;

		curSum = cur1.val + cur2.val;
		carry = curSum / 10;
		result = new ListNode(curSum % 10);
		pre = result;
		cur1 = cur1.next;
		cur2 = cur2.next;

		while (cur1 != null && cur2 != null) {
			curSum = cur1.val + cur2.val + carry;
			carry = curSum / 10;
			cur = new ListNode(curSum % 10);
			pre.next = cur;
			pre = cur;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}

		while (cur1 != null) {
			curSum = cur1.val + carry;
			carry = curSum / 10;
			cur = new ListNode(curSum % 10);
			pre.next = cur;
			pre = cur;
			cur1 = cur1.next;
		}

		while (cur2 != null) {
			curSum = cur2.val + carry;
			carry = curSum / 10;
			cur = new ListNode(curSum % 10);
			pre.next = cur;
			pre = cur;
			cur2 = cur2.next;
		}

		if (carry == 1) {
			cur = new ListNode(1);
			pre.next = cur;
			pre = cur;
		}

		return result;

	}
}
