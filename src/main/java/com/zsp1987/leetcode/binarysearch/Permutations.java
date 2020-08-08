package com.zsp1987.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if(null == nums){
            return result;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        permuteHelper(result, list, nums);
        return result;

    }

    private void permuteHelper(ArrayList<List<Integer>> result,
                               ArrayList<Integer> list,
                               int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            permuteHelper(result, list, nums);
            list.remove(list.size()-1);
        }

    }
}