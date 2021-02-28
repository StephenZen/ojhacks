package com.zsp1987.leetcode.datatype;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode<T> {
    public T label;
    public List<UndirectedGraphNode<T>> neighbors;

    public UndirectedGraphNode(T x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode<T>>();
    }
}
