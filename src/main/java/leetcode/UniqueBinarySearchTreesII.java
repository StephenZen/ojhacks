package leetcode;

import datatype.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*

 Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 
 */

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	ArrayList<TreeNode> helper(int left, int right) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if (left > right) {			// base condition
			res.add(null);
			return res;
		}

		for (int i = left; i <= right; i++) {
			ArrayList<TreeNode> leftList = helper(left, i - 1);
			ArrayList<TreeNode> rightList = helper(i + 1, right);
			for (int j = 0; j < leftList.size(); j++) {
				for (int k = 0; k < rightList.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					res.add(root);
				}
			}
		}
		return res;
	}
}

// 同样是递归 不同的是每次都是构建左右两边的树 将其按插在root两边