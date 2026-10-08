class Solution {
    public int rob(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) {
            dp[i] = -1;
        }

        return climb(0, cost, dp);
    }

    public int climb(int i, int[] cost, int[] dp) {
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(climb(i + 1, cost, dp),cost[i] + climb(i + 2, cost, dp));
    }
}
