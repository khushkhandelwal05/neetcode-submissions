class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        backtrack(nums, target, dp, ans, 0);
        return ans;
    }

    public void backtrack(int[] nums, int target, List<Integer> dp, List<List<Integer>> ans, int index) {
        if(target == 0) {
            ans.add(new ArrayList<>(dp));
            return;
        }

        if(target < 0) {
            return;
        }
        
        for(int i = index ; i< nums.length ; i++) {
            dp.add(nums[i]);
            backtrack(nums, target - nums[i], dp, ans, i);
            dp.remove(dp.size() - 1);
        }

    }
}
