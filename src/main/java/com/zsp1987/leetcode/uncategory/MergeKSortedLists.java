package com.zsp1987.leetcode.uncategory;

import java.util.Arrays;

import com.zsp1987.leetcode.datatype.ListNode;

public class MergeKSortedLists {
	public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
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

	ListNode<Integer> merge(ListNode<Integer> list1, ListNode<Integer> list2) {
		ListNode<Integer> cur = new ListNode<>(0);
		ListNode<Integer> hd = cur;

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
