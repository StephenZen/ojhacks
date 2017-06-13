package leetcode;

/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3. 
 */

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