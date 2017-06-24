package leetcode;

/*
 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list. 
 */

import datatype.ListNode;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;
		int i = 0;
		ListNode cur = head;
		ListNode pre = null;
		ListNode prepre = null;
		ListNode mNode = null;
		ListNode premNode = null;
		while (i < n) {
			prepre = pre;
			pre = cur;
			cur = cur.next;
			if (i == m - 1) {
				premNode = prepre;		// mark te reverse start
				mNode = pre;
			} else if (i >= m) {
				pre.next = prepre;		// begin to reverse
			}
			i++;
		}
		if (premNode != null)			// point node before reverse to end
			premNode.next = pre;
		mNode.next = cur;
		if (m == 1)
			return pre;
		return head;
	}
}

// 到m的时候标记一下 然后开始反转
