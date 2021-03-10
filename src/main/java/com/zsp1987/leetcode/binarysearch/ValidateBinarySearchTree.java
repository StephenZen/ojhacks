package com.zsp1987.leetcode.binarysearch;

import com.zsp1987.leetcode.datatype.TreeNode;

public class ValidateBinarySearchTree {
    private class ResultInfo {
        boolean isValid;
        int max;
        int min;

        public ResultInfo(boolean isValid, int max, int min) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
        }
    }

    public boolean isValidBST(TreeNode<Integer> root) {
        ResultInfo result = validateHelper(root);
        return result.isValid;
    }

    public ResultInfo validateHelper(TreeNode<Integer> node) {
        if (node == null) {
            return new ResultInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ResultInfo left = validateHelper(node.left);
        ResultInfo right = validateHelper(node.right);

        int max = right.max;
        int min = left.min;

        if (left.isValid == false || right.isValid == false) {
            return new ResultInfo(false, 0, 0);
        }

        if (node.left != null && node.val <= left.max ||
                node.right != null && node.val >= right.min) {
            return new ResultInfo(false, 0, 0);
        } else {
            max = Math.max(node.val, right.max);
            min = Math.min(node.val, left.min);
            return new ResultInfo(true, max, min);
        }
    }
}
