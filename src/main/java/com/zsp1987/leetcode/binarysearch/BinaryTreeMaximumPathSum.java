package com.zsp1987.leetcode.binarysearch;

import com.zsp1987.leetcode.datatype.TreeNode;

public class BinaryTreeMaximumPathSum {
    private class ResultType {
        int maxPath;
        int singlePath;

        public ResultType(int maxPath, int singlePath) {
            this.maxPath = maxPath;
            this.singlePath = singlePath;
        }
    }

    public int maxPathSum(TreeNode<Integer> root) {
        // write your code here
        ResultType result = helper(root);
        return result.maxPath;
    }

    private ResultType helper(TreeNode<Integer> node) {
        int maxPath, singlePath;
        
        if (node.left == null && node.right == null) {
            return new ResultType(node.val, node.val);
        } else if (node.left == null) {
            ResultType right = helper(node.right);
            int rightSinglePath = right.singlePath > 0 ? right.singlePath : 0;
            singlePath = rightSinglePath + node.val;
            maxPath = Math.max(singlePath, right.maxPath);
            return new ResultType(maxPath, singlePath);
        } else if (node.right == null) {
            ResultType left = helper(node.left);
            int leftSinglePath = left.singlePath > 0 ? left.singlePath : 0;
            singlePath = leftSinglePath + node.val;
            maxPath = Math.max(singlePath, left.maxPath);
            return new ResultType(maxPath, singlePath);
        } else {
            ResultType left = helper(node.left);
            ResultType right = helper(node.right);
            int leftSinglePath = left.singlePath > 0 ? left.singlePath : 0;
            int rightSinglePath = right.singlePath > 0 ? right.singlePath : 0;
            singlePath = Math.max(leftSinglePath + node.val, rightSinglePath + node.val);
            maxPath = Math.max(leftSinglePath + rightSinglePath + node.val, Math.max(left.maxPath, right.maxPath));
            return new ResultType(maxPath, singlePath);
        }

    }
}
