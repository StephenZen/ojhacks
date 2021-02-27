package com.zsp1987.leetcode.uncategory;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    ArrayList<Integer> list = new ArrayList<Integer>();
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return null;

        backtrack(list, nums, results);
        return results;
    }

    void backtrack(ArrayList<Integer> list, int[] nums,
                   List<List<Integer>> results) {

        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                    backtrack(list, nums, results);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}

// backtracking 注�? 构建新容器的方法 �?用clone
