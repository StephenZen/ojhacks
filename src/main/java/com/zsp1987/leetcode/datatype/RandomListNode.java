package com.zsp1987.leetcode.datatype;

public class RandomListNode<T> {

    public T label;
    public RandomListNode<T> next, random;

    public RandomListNode(T x) {
        this.label = x;
    }
}
