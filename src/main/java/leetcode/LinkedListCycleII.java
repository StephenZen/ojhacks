package leetcode;

/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space? 
 */

import java.util.HashSet;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head){
        if(head == null) return null;
        ListNode fast = head, slow = head;
        do{
            if(fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }while( fast != slow);

        while( head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

	public ListNode detectCycleOld(ListNode head) {
		if (head == null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		HashSet<ListNode> set = new HashSet<ListNode>();
		set.add(head);
		while (fast.next != null && fast.next.next != null) {
			if (!set.add(slow.next))
				return slow.next;
			else {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return null;
	}
}

// 前部分跟cycle1是一样的, 直到追击成功,因为当快慢相遇时 快的刚好比慢的多绕了环n圈,
// 假设环前路程为x, 环的长度是y, 相遇点超过起点z 则2(x+z) = x+z+ny  => x = ny-z
// 所以头从起点走 刚好和慢的在环的开头相遇
// 老思路: slow 第一次加不进去 就是cycle的起点