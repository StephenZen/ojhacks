package com.zsp1987.leetcode.linkedlist;

import com.zsp1987.leetcode.annotation.LeetCode;
import org.junit.jupiter.api.Test;

import java.util.List;

@LeetCode(206)
public class ReverseLinkedList {

    // iteratively
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    ListNode tail;

    // recursive
    public ListNode reverseListR(ListNode head) {
        if (head == null)
            return null;
        tail = head;
        reverse(head);
        return tail;

    }

    ListNode reverse(ListNode head) {
        if (head.next != null) {
            tail = head.next;
            reverse(head.next).next = head;
            head.next = null;
        }
        return head;
    }


    public ListNode reverseListR2(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode last = reverseListR2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print(ListNode node) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
                print(node.next);
            }
        }
    }

    @Test
    public void test() {
		ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next=node2;
        node2.next=node3;

        ListNode head = node1;
        head.print(head);

        System.out.println("");

        ListNode reversed = reverseListR2(head);
        reversed.print(reversed);

    }
}
