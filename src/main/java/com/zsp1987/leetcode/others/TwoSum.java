package com.zsp1987.leetcode.others;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum 
 *
 * @author zsp19
 */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
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
