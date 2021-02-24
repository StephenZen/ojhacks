package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Given a singly linked list L: L0â†’L1â†’â€¦â†’Ln-1â†’Ln,
 reorder it to: L0â†’Lnâ†’L1â†’Ln-1â†’L2â†’Ln-2â†’â€¦

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode rightHead = slow.next;
		slow.next = null;
		rightHead = reverse(rightHead);

		ListNode leftcur = head;
		ListNode rightcur = rightHead;
		while (leftcur.next != null && rightcur.next != null) {
			ListNode leftnxt = leftcur.next;
			leftcur.next = rightcur;
			leftcur = leftnxt;
			ListNode rightnxt = rightcur.next;
			rightcur.next = leftcur;
			rightcur = rightnxt;
		}
		if (leftcur.next == null) {
			leftcur.next = rightcur;
			rightcur.next = null;
		} else {
			ListNode leftnxt = leftcur.next;
			leftcur.next = rightcur;
			leftcur = leftnxt;
			rightcur.next = leftcur;
			leftcur.next = null;
		}

	}

	ListNode reverse(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		else {
			ListNode pre = head;
			ListNode cur = pre.next;
			pre.next = null;
			ListNode nxt = cur.next;
			while (nxt != null) {
				cur.next = pre;
				pre = cur;
				cur = nxt;
				nxt = cur.next;
			}
			cur.next = pre;
			return cur;
		}
	}
}

// ç”¨ä¸¤ä¸ªpointerè·‘å‡ºlistçš„ä¸­ç‚¹, å°†listçš„å?³å?Šéƒ¨åˆ†reverse, ç„¶å?Žå°†å·¦å?Šè¾¹å’Œå??è¿‡æ?¥çš„å?³å?Šè¾¹ä¾?æ¬¡æ?’å…¥
