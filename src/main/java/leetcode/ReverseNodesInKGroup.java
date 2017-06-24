package leetcode;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 */

import datatype.ListNode;

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