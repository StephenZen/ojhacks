package leetcode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */

public class SubmissionDetails {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null)
			return null;
		if (n == 0)
			return head;

		ListNode cur = head;
		int count = 1;
		while (cur.next != null) {
			cur = cur.next;
			count++;
		}
		cur.next = head;
		n = n % count;
		cur = head;
		int i = 1;
		int j = count - n;
		while (i < j) {
			cur = cur.next;
			i++;
		}

		ListNode result = cur.next;
		cur.next = null;
		return result;
	}
}