package com.zsp1987.leetcode.algorithm;

import com.zsp1987.leetcode.datatype.TreeLinkNode;

public class NonLinearTraverse {

    public <T> void traverse(TreeLinkNode<T> root) {
        traverse(root.left);
        traverse(root.right);
    }
}
