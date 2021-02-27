package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (null == head)
			return head;
		ListNode current = head;
		int val;
		val = current.val;
		while (null != current.next) {
			if (val == current.next.val && current.next.next != null) {
				current.next = current.next.next;
			} else if (val == current.next.val && current.next.next == null) {
				current.next = null;
			} else {
				val = current.next.val;
				current = current.next;
			}
		}
		return head;
	}
}

// 循环检查下下个node的value