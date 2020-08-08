package com.zsp1987.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

/*
 * 
 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},

 1
 \
 2
 /
 3

 return [1,2,3]. 

 */

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversalOld(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		return list;

	}

	public void visit(TreeNode node, List<Integer> list) {
		list.add(node.val);
		if (null != node.left) {
			visit(node.left, list);
		}
		if (null != node.right) {
			visit(node.right, list);
		}

	}
	public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rResult = new LinkedList<TreeNode>();		// reverse result
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        temp.add(root);
        while (temp.size() != 0) {
            TreeNode node = temp.pop();
            rResult.add(node);
            if (node.right != null) {
                TreeNode nodeR = node.right;
                temp.push(nodeR);
            }
            if (node.left != null) {
                TreeNode nodeL = node.left;
                temp.push(nodeL);
            }

        }
        while (0 != rResult.size()) {
            result.add(rResult.removeFirst().val);
        }

        return result;
	}
}

// preorder 就先加节点 �?加左�?�
