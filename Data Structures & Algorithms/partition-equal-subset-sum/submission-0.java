class Solution {

    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for(int num : nums) {
            tot += num;
        }
        if (tot % 2 != 0) return false;
        tot = tot / 2;
        dp = new Boolean[nums.length][tot + 1];
        return canPartition(nums, tot, 0);
    }

    public boolean canPartition(int[] nums,int sum, int i) {
        if(sum == 0) return true;
        if(i == nums.length || sum < 0) return false;
        if(dp[i][sum] != null) return dp[i][sum];

        return dp[i][sum] = canPartition(nums, sum - nums[i], i + 1) || canPartition(nums, sum, i + 1);
    }
}
