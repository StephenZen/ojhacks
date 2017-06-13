package leetcode;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int fast = 0, slow = 0, curSum = 0;
		int min = Integer.MAX_VALUE;
		while (fast < n) {
			while (curSum + nums[fast] >= s) {
				curSum = curSum - nums[slow];
				int count = fast - slow + 1;
				min = min < count ? min : count;
				slow++;
			}
			curSum = curSum + nums[fast];
			fast++;
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	//O(nlogn) method
	public int minSubArrayLen2(int s, int[] nums) {
		if (nums.length == 0)
			return 0;

		int[] sums = new int[nums.length];
		sums[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
		if (sums[nums.length - 1] < s)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int l = i;
			int r = nums.length - 1;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (sums[mid] - sums[i] + nums[i] == s) {
					l = mid;
					break;
				} else if (sums[mid] - sums[i] + nums[i] < s) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
			if (l >= sums.length)
				break;
			ans = Math.min(ans, l - i + 1);
		}

		return (ans == Integer.MAX_VALUE ? 0 : ans);
	}
}

// 双指针 快慢指针保证之间的值刚好小于sum 然后调整慢指针的边界
// 二分查找的思路: 先将所有数递加, 将前i项的和存到一个array里
// 从0到n-1, 每次做binary search直到找到从i到x段最接近s的位置, 依次比较每个长度找到最短的长度