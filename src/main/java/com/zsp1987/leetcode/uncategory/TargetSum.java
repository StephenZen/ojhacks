package com.zsp1987.leetcode.uncategory;

public class TargetSum {

    class Solution {
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {

            backtrack(0, target, 0, nums);
            return count;
        }

        void backtrack(int sum, int target, int pos, int[] nums) {
            if (pos == nums.length) {
                if (sum == target) {
                    count++;
                }
                return;
            }

            backtrack(sum + nums[pos], target, pos + 1, nums);
            backtrack(sum - nums[pos], target, pos + 1, nums);
        }
    }
}
