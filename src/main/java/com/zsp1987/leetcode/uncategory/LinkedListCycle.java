package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space? 
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		if (head == null)
			return false;

		ListNode fast = head;
		ListNode slow = head;

		if (fast.next != fast && fast.next != null)
			fast = fast.next;

		while (fast.next != null && fast.next.next != null) {
			if (fast == slow)
				return true;
			fast = fast.next.next;
			//if (slow.next != null)  //not necessary cause fast already checked!.
            slow = slow.next;
		}

		return false;

	}
}

// 两个指针一起跑 快的跑两步 慢的跑一步 相�?�了就有环