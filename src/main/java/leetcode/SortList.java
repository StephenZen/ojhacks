package leetcode;

/*
 Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)      //list size == 0 or == 1
			return head;
		ListNode fast = head.next.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode rightStart = sortList(slow.next);
		slow.next = null;
		return merge(sortList(head), rightStart);
	}

	public ListNode merge(ListNode h1, ListNode h2) {
		ListNode hn = new ListNode(Integer.MIN_VALUE);
		ListNode cur = hn;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				cur.next = h1;
				h1 = h1.next;
			} else {
				cur.next = h2;
				h2 = h2.next;
			}
			cur = cur.next;
		}
		if (h1 != null)
			cur.next = h1;
		if (h2 != null)
			cur.next = h2;
		return hn.next;
	}
}

// merge sort
// use fast and slow runner to find the middle point of list
// divide list until size 0 or 1
// merge by creating new list