package leetcode;

/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 */

import java.util.Arrays;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		if (lists == null || n == 0)
			return null;
		if (n == 1)
			return lists[0];
		if (n == 2)
			return merge(lists[0], lists[1]);
		int i = n / 2;
		return merge(mergeKLists(Arrays.copyOfRange(lists, 0, i)),
				mergeKLists(Arrays.copyOfRange(lists, i, n)));
	}

	ListNode merge(ListNode list1, ListNode list2) {
		ListNode cur = new ListNode(0);
		ListNode hd = cur;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur.next = list1;
				cur = cur.next;
				list1 = list1.next;
			} else {
				cur.next = list2;
				cur = cur.next;
				list2 = list2.next;
			}
		}

		if (list1 != null)
			cur.next = list1;
		if (list2 != null)
			cur.next = list2;

		return hd.next;
	}
}

/*
 * i, j将list对半分了 divide 到分到最小的单元 要么是 0， 1， 2 三中的一个情况， 然后用merge conquar
 */
