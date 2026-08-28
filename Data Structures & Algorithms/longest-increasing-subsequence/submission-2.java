class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        for(int i = 0 ; i < nums.length ; i++) {
            ans = Math.max(ans,lengthOfLIS(nums, i));
        }
        return ans;
        
    }

    public int lengthOfLIS(int[] nums, int start) {
        int ans = 1;
        if(dp[start]!= -1) return dp[start];
        for(int i = start + 1 ; i < nums.length ; i++) {
            if(nums[i] > nums[start]) ans = Math.max(ans, 1 + lengthOfLIS(nums, i));
        }

        return dp[start] = ans;

    }
}
