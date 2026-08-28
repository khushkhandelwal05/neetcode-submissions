class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(rob(nums, dp, 0), rob(nums, dp, 1));
    }

    public int rob(int[] nums, int[] dp, int i) {
        if(i == nums.length) return 0;
        if(i >= nums.length - 2) return nums[i];

        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(rob(nums, dp, i + 2), rob(nums, dp, i + 3)) + nums[i];
    }
}
