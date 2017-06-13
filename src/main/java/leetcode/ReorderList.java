package leetcode;

/*
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}. 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode rightHead = slow.next;
		slow.next = null;
		rightHead = reverse(rightHead);

		ListNode leftcur = head;
		ListNode rightcur = rightHead;
		while (leftcur.next != null && rightcur.next != null) {
			ListNode leftnxt = leftcur.next;
			leftcur.next = rightcur;
			leftcur = leftnxt;
			ListNode rightnxt = rightcur.next;
			rightcur.next = leftcur;
			rightcur = rightnxt;
		}
		if (leftcur.next == null) {
			leftcur.next = rightcur;
			rightcur.next = null;
		} else {
			ListNode leftnxt = leftcur.next;
			leftcur.next = rightcur;
			leftcur = leftnxt;
			rightcur.next = leftcur;
			leftcur.next = null;
		}

	}

	ListNode reverse(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		else {
			ListNode pre = head;
			ListNode cur = pre.next;
			pre.next = null;
			ListNode nxt = cur.next;
			while (nxt != null) {
				cur.next = pre;
				pre = cur;
				cur = nxt;
				nxt = cur.next;
			}
			cur.next = pre;
			return cur;
		}
	}
}

// 用两个pointer跑出list的中点, 将list的右半部分reverse, 然后将左半边和反过来的右半边依次插入
