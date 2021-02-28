package com.zsp1987.leetcode.datatype;

public class TreeLinkNode<T> {
    T val;
    public TreeLinkNode<T> left, right, next;

    TreeLinkNode(T x) {
        val = x;
    }
}
