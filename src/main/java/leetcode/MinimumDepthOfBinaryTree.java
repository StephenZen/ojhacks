package leetcode;

/*
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

import datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

// bfs 往队列里放 直到发现第一个叶 return 叶的当前行