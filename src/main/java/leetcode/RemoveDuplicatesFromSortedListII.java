package leetcode;

/*
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3. 
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;

		ListNode cur = head;
		ListNode next = null;

		ListNode del = null;
		ListNode last = null;
		ListNode result = null;

		while (cur.next != null) {
			next = cur.next;
			if (cur.val == next.val) {
				del = cur;

			} else if (cur.val != next.val
					&& (del == null || cur.val != del.val)) {
				if (result == null) {
					result = cur;
					last = cur;
					last.next = null;
				} else {
					last.next = cur;
					last = cur;
					last.next = null;
				}
			}
			cur = next;
		}

		if (del == null || cur.val != del.val) {
			if (result == null) {
				result = cur;
				last = cur;
				last.next = null;
			} else {
				last.next = cur;
				last = cur;
				last.next = null;
			}
		}

		return result;
	}
}
