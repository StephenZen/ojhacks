package com.zsp1987.leetcode.dp;

import com.zsp1987.leetcode.datatype.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    Map<TreeNode<Integer>, Integer> memo = new HashMap<>();

    public int rob(TreeNode<Integer> root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        Integer robRoot = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        Integer notRobRoot = rob(root.left) + rob(root.right);

        int res = Math.max(robRoot, notRobRoot);
        memo.put(root, res);
        return res;
    }
}
