class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, res, sub, vis);
        return res;
    }


    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> sub, boolean[] vis) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
        }

        for(int j = 0 ; j < nums.length ; j++) {
            if(vis[j]) {
                continue;
            }
            sub.add(nums[j]);
            vis[j] = true;
            dfs(nums, res, sub, vis);
            sub.remove(sub.size() - 1);
            vis[j] = false;
        }
    }
}
