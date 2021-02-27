package com.zsp1987.leetcode.uncategory;

import com.zsp1987.leetcode.datatype.ListNode;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;

        ListNode cur = head;
        int count = 1;

        // count total
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }

        //point tail to head
        cur.next = head;
        k = k % count;


        cur = head;
        int i = 1;
        int j = count - k;
        while (i < j) {
            cur = cur.next;
            i++;
        }

        ListNode result = cur.next;
        cur.next = null;
        return result;
    }
}

// ç»Ÿè®¡ å?–ä½™ é‡?è¿ž
