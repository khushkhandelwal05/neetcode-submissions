class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(nums, 0,target, res, sub);
        return res;
    }

    public void dfs(int[] nums, int i, int target, List<List<Integer>> res, List<Integer> sub) {
        if(target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if(i == nums.length) return;

        if(target - nums[i] >= 0) {
            sub.add(nums[i]);
            dfs(nums, i, target - nums[i], res, sub);
            sub.remove(sub.size() - 1);
        }
        dfs(nums, i + 1, target, res, sub);
    }
}
