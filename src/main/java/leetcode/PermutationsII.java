package leetcode;

/*
 Given a collection of numbers that might contain duplicates,
 return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack(result, list, visited, nums);
        return result;
    }

    void backtrack(List<List<Integer>> result, ArrayList<Integer> list, int[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
        } else {

            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                    continue;
                }

                visited[i] = 1;
                list.add(nums[i]);
                backtrack(result, list, visited, nums);
                list.remove(list.size() - 1);
                visited[i] = 0;
            }

        }

    }
}

// 注意回溯时候的重复
