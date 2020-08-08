package com.zsp1987.leetcode;

import com.zsp1987.leetcode.datatype.ListNode;

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

// 到m的时候标记一下 然�?�开始�??转
