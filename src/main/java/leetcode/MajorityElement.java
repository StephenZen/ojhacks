package leetcode;

/*
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElementOld(int[] nums) {
		int n = nums.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {

			if (map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + 1);
			else
				map.put(nums[i], 1);

			if (map.get(nums[i]) > n / 2)
				return nums[i];

		}
		return 0;

	}

	public int majorityElement(int[] nums) {

		int major = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else
				count--;

		}
		return major;
	}
}

// 老方法: 加入hashmap过半就return
// 巧方法: 用个计数器, 因为最大值数量过半, 所以计数器最后肯定不会被重置.