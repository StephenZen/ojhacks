package dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetII{
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null==nums || nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        helper(result, subset, nums, 0);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result,
                        ArrayList<Integer> subset,
                        int[] nums,
                        int pos){
        result.add(new ArrayList(subset));

        for(int i = pos; i < nums.length; i++){
            if(i > pos && nums[i] == nums[i-1] ){
                continue;
            }
            subset.add(nums[i]);
            helper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
