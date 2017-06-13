package leetcode;

/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null)
			return result;
		List<Integer> list = new ArrayList<Integer>();
		subsets(root, list, 0, sum);
		return result;

	}

	void subsets(TreeNode node, List<Integer> list, int cursum, int sum) {
		List<Integer> listN = new ArrayList<Integer>(list);
		listN.add(node.val);
		cursum += node.val;
		if (node.left == null && node.right == null) {
			if (cursum == sum) {
				List<Integer> newList = new ArrayList<Integer>(listN);
				result.add(newList);
			}
			return;
		} else {
			if (node.left != null)
				subsets(node.left, listN, cursum, sum);
			if (node.right != null)
				subsets(node.right, listN, cursum, sum);
		}
	}
}

// 跟pathsum 一样的思路dfs遍历 不同点每层多加一个列表保存当前队列