package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.TreeNode;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		ArrayList<TreeNode> lvlnodes = new ArrayList<TreeNode>();
		lvlnodes.add(root);
		return bfs(lvlnodes, 1);
	}

	int bfs(List<TreeNode> lvlnodes, int lvl) {
		ArrayList<TreeNode> lvlnodesNext = new ArrayList<TreeNode>();
		for (TreeNode node : lvlnodes) {
			if (node.left == null && node.right == null) {
				return lvl;
			} else {
				if (node.left != null)
					lvlnodesNext.add(node.left);
				if (node.right != null)
					lvlnodesNext.add(node.right);
			}
		}
		return bfs(lvlnodesNext, lvl + 1);
	}
	
	public int dfs(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null & root.right == null) return 1;
        else if(root.left !=null && root.right!=null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return 1 + (left<right?left:right);
        }
        else if(root.left == null){
            return 1 + minDepth(root.right);
        }
        else{
            return 1 + minDepth(root.left);
        }
        

    }
}

// bfs 往队列里放 直到�?�现第一个�?� return �?�的当�?行