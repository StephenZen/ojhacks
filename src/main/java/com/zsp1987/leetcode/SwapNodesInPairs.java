package com.zsp1987.leetcode;

import com.zsp1987.leetcode.datatype.ListNode;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode root = head.next;
			swap(head);
			return root;
		}

	}

	ListNode swap(ListNode a) {
		if (a == null || a.next == null) {
			return a;
		} else {
			ListNode temp = a;
			ListNode temp2 = a.next.next;
			a = a.next;
			a.next = temp;
			a.next.next = temp2;
			ListNode nextNode = swap(a.next.next);
			a.next.next = nextNode;
			return a;
		}
	}
}

/* 递归调用 �?次处�?�两个 */