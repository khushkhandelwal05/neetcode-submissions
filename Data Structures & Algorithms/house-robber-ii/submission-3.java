class Solution {
    public int rob(int[] nums) {
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);
        return Math.max(Math.max(rob(nums, dp1, 0, true), rob(nums, dp2, 1, false)), rob(nums, dp2, 2, false));
    }

    public int rob(int[] nums, int[] dp, int i, boolean isFirst) {
        if(i >= nums.length) return 0;
        if(isFirst && nums.length != 1) {
            if(i == nums.length - 1) return 0;
        }
        if(i >= nums.length - 2) return nums[i];

        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(rob(nums, dp, i + 2, isFirst), rob(nums, dp, i + 3, isFirst)) + nums[i];
    }
}

