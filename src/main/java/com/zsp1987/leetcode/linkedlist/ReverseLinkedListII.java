package com.zsp1987.leetcode.linkedlist;

import com.zsp1987.leetcode.datatype.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        int i = 0;
        ListNode cur, pre, prePre, mNode, premNode;
        cur = head;
        pre = null;
        mNode = null;
        premNode = null;
        while (i < n) {
            prePre = pre;
            pre = cur;
            cur = cur.next;
            if (i == m - 1) {
                premNode = prePre;        // mark te reverse start
                mNode = pre;
            } else if (i >= m) {
                pre.next = prePre;        // begin to reverse
            }
            i++;
        }
        if (premNode != null)            // point node before reverse to end
            premNode.next = pre;
        mNode.next = cur;
        if (m == 1)
            return pre;
        return head;
    }
}
