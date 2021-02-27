package com.zsp1987.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (null == nums || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();

        subsetHelper(result, subset, nums, 0);

        return result;
    }

    private void subsetHelper(ArrayList<ArrayList<Integer>> result,
                              ArrayList<Integer> subset,
                              int[] nums,
                              int pos) {

        result.add(new ArrayList<Integer>(subset));

        for (int i = pos; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetHelper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }

    }
}
