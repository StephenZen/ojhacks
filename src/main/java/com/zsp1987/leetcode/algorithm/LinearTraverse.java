package com.zsp1987.leetcode.algorithm;

import com.zsp1987.leetcode.datatype.ListNode;

public class LinearTraverse {

    public void iterateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // traverse logic
        }
    }

    public void iterateList(ListNode<Integer> head) {
        for (ListNode<Integer> cur = head; cur != null; cur = cur.next) {
            // traverse logic for cur
        }
    }

    public void recurseList(ListNode<Integer> head) {
        if (head == null)
            return;
        // traverse logic
        recurseList(head.next);
    }

}
