package leetcode;

/*
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗            
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 */

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

// 如果最后两个列表intersect, 后半段是一样的, 所以intersection的点肯定不在前面的差异段
// 跳过之后 当两个点为同值之后, intersection 开始