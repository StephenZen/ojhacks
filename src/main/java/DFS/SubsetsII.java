    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(null==nums || nums.length == 0){
            return result;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        subsetHelper(result, subset, nums, 0);
        return result;
    }

    private void subsetHelper(ArrayList<ArrayList<Integer>> result,
                            ArrayList<Integer> subset,
                            int[] nums,
                            int pos){
        result.add(new ArrayList(subset));
        
        for(int i = pos; i < nums.length; i++){
            if(i > pos && nums[i] == nums[i-1] ){
                continue;
            }
            subset.add(nums[i]);
            subsetHelper(result, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }