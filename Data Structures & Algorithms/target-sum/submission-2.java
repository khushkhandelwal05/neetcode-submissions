class Solution {
    int[][] dp;
    int sum = 0;
    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) {
            sum += num;
        }
        dp = new int[nums.length][target + (2 *sum) + 1];
        sum = sum + target;
        for(int i = 0 ; i < dp.length ; i++) Arrays.fill(dp[i], -1);
        return findTargetSumWays(nums, target, 0);
    }

    public int findTargetSumWays(int[] nums, int target, int i) {
        if(i == nums.length) {
            if(target == 0) return 1;
            return 0;
        }

        if(dp[i][sum - target] != -1) return dp[i][sum - target];

        return dp[i][sum - target] = findTargetSumWays(nums, target - nums[i], i + 1) + findTargetSumWays(nums, target + nums[i], i + 1);
    }
}
