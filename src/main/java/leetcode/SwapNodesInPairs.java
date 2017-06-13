package leetcode;

/*
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed. 
 */

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

/* 递归调用 每次处理两个 */