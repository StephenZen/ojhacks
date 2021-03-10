package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode<Integer> insertionSortList(ListNode<Integer> head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode<Integer> pre = head, cur = head.next;

        int count = 1;
        outter:
        while (cur != null) {

            ListNode<Integer> node = head;
            ListNode<Integer> prenode = null;

            for (int i = 0; i < count; i++) {
                if (cur.val < node.val) {
                    pre.next = cur.next;
                    if (node == head) {
                        cur.next = head;
                        head = cur;
                    } else {
                        prenode.next = cur;
                        cur.next = node;
                    }
                    cur = pre.next;
                    count++;
                    continue outter;
                }
                prenode = node;
                node = node.next;
            }
            pre = cur;
            cur = cur.next;
            count++;
        }

        return head;
    }
}
