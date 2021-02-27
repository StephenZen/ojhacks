package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

public class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode nextStart = head;
		ListNode currentTail = dummy;
		ListNode end = nextStart;
		while (end != null) {
			ListNode start = nextStart;
			end = start;
			int i = 0;

			while (end != null && i < k - 1) { // get some elements
				i++;
				end = end.next;
			}
			if (end != null) {
				nextStart = end.next;
				currentTail.next = end;
				currentTail = reverseLinkedList(start, end);
			}
		}
		currentTail.next = nextStart;
		return dummy.next;
	}

	private ListNode reverseLinkedList(ListNode start, ListNode end) {
		if (start == end) {
			return end;
		}
		ListNode prevTail = reverseLinkedList(start.next, end);
		prevTail.next = start;
		start.next = null;
		return start;
	}

}