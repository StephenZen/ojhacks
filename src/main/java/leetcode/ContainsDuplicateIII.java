package leetcode;

import java.util.TreeSet;

/*
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length == 0 || k <= 0) {
			return false;
		}

		final TreeSet<Integer> values = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {

			Integer floor = values.floor(nums[i] + t);
			Integer ceil = values.ceiling(nums[i] - t);
			if ((floor != null && floor >= nums[i])
					|| (ceil != null && ceil <= nums[i])) {
				return true;
			}

			values.add(nums[i]);
			if (i >= k) {
				values.remove(nums[i - k]);
			}
		}

		return false;
	}
}

// 用一个treeset来维护一个排序的set
// 到一个位置 如果当前set中有在t上下范围的数就找到了
// 否则加入当前数 并移除此数前k位置的那个数 保持set的选择范围
