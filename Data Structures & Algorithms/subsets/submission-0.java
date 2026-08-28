class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> dp = new ArrayList<>();
        backtrack(nums, dp, ans, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> dp, List<List<Integer>> ans, int ind) {
        // Always add the current subset (copy of dp)
        ans.add(new ArrayList<>(dp));

        // Try adding each element one by one
        for (int i = ind; i < nums.length; i++) {
            dp.add(nums[i]);                        // choose
            backtrack(nums, dp, ans, i + 1);        // explore
            dp.remove(dp.size() - 1);               // un-choose (backtrack)
        }
    }
}
