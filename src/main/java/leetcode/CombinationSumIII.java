package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {

	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		if (k == 0 || n <= 0)
			return result;
		if (n > 45)
			return result;
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = i + 1;
		}
		backtrack(nums, k, n, 0, 0, 0);
		return result;
	}

	public void backtrack(int[] nums, int k, int n, int lvl, int sum, int count) {
		if (count == k && sum == n) {
			List<Integer> newList = new ArrayList<Integer>(list);
			result.add(newList);
			return;
		} else if (sum > n || lvl > 8) {
			return;
		} else {
			list.add(nums[lvl]);
			backtrack(nums, k, n, lvl + 1, sum + nums[lvl], count + 1);
			list.remove(list.size() - 1);
			backtrack(nums, k, n, lvl + 1, sum, count);
		}

	}
}

// 回溯 注意最后加入list到result中时候一定要new 一个新的list 不然global的list会被不断的擦写