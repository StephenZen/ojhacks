package com.zsp1987.leetcode.others;

import java.util.HashMap;

/**
 * Created by spzhang on 6/22/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                result[0] = map.get(remain);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
