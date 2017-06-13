package leetcode;

/*
 Given a binary tree, return the level order traversal of its nodes' values. 
 (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7

 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		build(result, 0, root);
		return result;

	}

	void build(List<List<Integer>> result, int lvl, TreeNode node) {
		int n = result.size();
		List<Integer> lvlList;
		if (lvl > n - 1) {
			lvlList = new ArrayList<Integer>();
			lvlList.add(node.val);
			result.add(lvlList);
		} else {
			lvlList = result.get(lvl);
			lvlList.add(node.val);
		}
		if (node.left != null)
			build(result, lvl + 1, node.left);
		if (node.right != null)
			build(result, lvl + 1, node.right);

	}
}

// 遍历每层 用全局变量记录结果 用lvl记录层高 若当前lvl的层高大于全局变量的长度 就生成新层, 否则就取出当前lvl对应的列表 往里面填充