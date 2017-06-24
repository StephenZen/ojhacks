package leetcode;

import datatype.ListNode;

/*
 Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode pre = head, cur = head.next;

        int count = 1;
        outter:
        while (cur != null) {

            ListNode node = head;
            ListNode prenode = null;

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

// 两个标记 一标记前 一标记当前, 每次都将当前的与排序好的array作比较插入
// 注意的是head的位置 是否需要变化