package leetcode;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {

		if (nums.length == 0)
			return -1;
		if (nums.length == 1)
			return nums[0];
		int s = 0;
		int e = nums.length - 1;

		while (s < e) {
			int m = (s + e) / 2;
			if (s > m - 1) { // only two left;
				return Math.min(nums[s], nums[e]);
			}
			if (nums[m] < nums[m - 1])
				return nums[m];
			else if (nums[m] > nums[e])
				s = m + 1;
			else
				e = m - 1;

		}
		return nums[s];
	}
}

// 修改recursive到interation
// 如果中值比中值减一小 说明递增到了尽头 中值刚好最小
// 如果中值比右值大 说明绕了一半多了 最小值肯定在右边
// 否则在左边
