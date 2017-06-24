package leetcode;

import datatype.ListNode;

/*
 Remove all elements from a linked list of integers that have value val.

 Example
 Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 Return: 1 --> 2 --> 3 --> 4 --> 5 
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode start = head;
		ListNode cur = head;
		while (cur != null && cur.val == val) {
			cur = cur.next;
			start = cur;
		}
		if (cur == null)
			return null;
		ListNode pre = cur;
		cur = cur.next;
		while (cur != null) {
			if (cur.val != val) {
				pre.next = cur;
				pre = cur;
			}
			cur = cur.next;
		}
		pre.next = cur;

		return start;
	}
}

// 用pre和cur链接断掉的情况
// 注意一下边界情况 如果一开始就是要删的值, 要一直检查到第一个不是要删的值开始
