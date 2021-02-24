package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int n = 0, m = 0;
		ListNode a = headA, b = headB;

		while (a != null) {
			a = a.next;
			n++;
		}
		while (b != null) {
			b = b.next;
			m++;
		}

		a = headA;
		b = headB;

		if (n > m) {
			int diff = n - m;
			for (int i = 0; i < diff; i++) {
				a = a.next;
			}
		} else {
			int diff = m - n;
			for (int i = 0; i < diff; i++) {
				b = b.next;
			}
		}

		while (a != null || b != null) {

			if (a.val != b.val) {
				a = a.next;
				b = b.next;
			} else {
				return a;
			}
		}
		return null;
	}
}

// 如果最�?�两个列表intersect, �?��?�段是一样的, 所以intersection的点肯定�?在�?�?�的差异段
// 跳过之�?� 当两个点为�?�值之�?�, intersection 开始