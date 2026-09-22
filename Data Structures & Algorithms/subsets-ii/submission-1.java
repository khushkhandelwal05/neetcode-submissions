class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> sub, int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for(int i = idx ; i <= nums.length ; i++) {
            if(i == nums.length) {
                res.add(new ArrayList<>(sub));
                continue;
            }
            if(i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            sub.add(nums[i]);
            dfs(nums, res, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
}
