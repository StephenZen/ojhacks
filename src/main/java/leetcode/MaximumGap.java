package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumGap {

	/*
	 * brucket sort
	 */
	public int MaximumGapmaximumGap(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;

		// get the max and min value of the array
		int min = nums[0], max = nums[0];

		for (int i : nums) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}

		// the minimum possibale gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		int[] bucketsMIN = new int[nums.length - 1]; // store the min value in
													// that bucket
		int[] bucketsMAX = new int[nums.length - 1]; // store the max value in
													// that bucket
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

		// put numbers into buckets
		for (int i : nums) {
			if (i == min || i == max)
				continue;
			int idx = (i - min) / gap; // index of the right position in the
										// buckets
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}

		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < nums.length - 1; i++) {
			if (bucketsMIN[i] == Integer.MAX_VALUE
					&& bucketsMAX[i] == Integer.MIN_VALUE)
				// empty bucket
				continue;
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); // updata the final max value gap

		return maxGap;
	}

	/* radix sort */
	class Solution {

		List<Integer> zeros = new ArrayList<Integer>();
		List<Integer> ones = new ArrayList<Integer>();

		public int maximumGap(int[] num) {
			if (num == null || num.length < 2) {
				return 0;
			}
			for (int b = 0; b < 31; b++) {
				putIntoBuckets(num, b);
				putFromBuckets(num);
			}
			return maximumGapFromSorted(num);
		}

		public void putIntoBuckets(int[] num, int b) {
			zeros.clear();
			ones.clear();

			int mask = 1 << b;
			for (int i : num) {
				if ((i & mask) == 0) {
					zeros.add(i);
				} else {
					ones.add(i);
				}
			}
		}

		public void putFromBuckets(int[] num) {
			int i = 0;
			for (int z : zeros) {
				num[i++] = z;
			}
			for (int o : ones) {
				num[i++] = o;
			}
		}

		public int maximumGapFromSorted(int[] num) {
			int maxGap = 0;
			for (int i = 0; i < num.length - 1; i++) {
				maxGap = Math.max(maxGap, num[i + 1] - num[i]);
			}
			return maxGap;
		}

	}

}

// 桶排序法(在同一个interval里的差值肯定不是答案)
// 第一遍扫array 确定最大值和最小值 确定区间, 然后除以个数-1 建立桶和interval的大小
// 建立两个array分别储存每个interval的最大值和最小值
// 再扫一边 用这个interval的最小值减上格interval的最大值 global最大的就是答案
