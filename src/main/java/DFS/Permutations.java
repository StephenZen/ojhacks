    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        
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