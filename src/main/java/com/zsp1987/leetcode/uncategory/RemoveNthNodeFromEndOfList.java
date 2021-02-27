package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

public class RemoveNthNodeFromEndOfList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {

	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;

	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
	public ListNode removeNthFromEndOld (ListNode head, int n) {
		int i = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			i++;
		}
		node = head;
		if (n == i)
			return head.next;
		else {
			for (int j = 1; j < i - n; j++) {
				node = node.next;
			}
			node.next = node.next.next;
		}
		return head;
	}
}

/*
 * �?方法: �??历两次 第一次求长度 第二次删 �?�?�度O(2n)
 * 新方法：两个指针 快指针先跑出n个空档， 然�?�一起跑， 直到快的reach end 
 */