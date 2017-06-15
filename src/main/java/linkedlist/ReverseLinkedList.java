package linkedlist;

import datatype.ListNode;

/*
 Reverse a singly linked list.
 */
public class ReverseLinkedList {

	// iteratively
	public ListNode reverseListI(ListNode head) {
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
}

// 用iterative 和recursive来将linkedlist倒置
// 具体看代码
