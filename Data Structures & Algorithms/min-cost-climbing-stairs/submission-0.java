class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        for(int i = 0 ; i < cost.length ; i++) dp[i] = -1;
        return Math.min(minCostClimbingStairs(cost,  dp, 0), minCostClimbingStairs(cost,  dp, 1));
    }

    public int minCostClimbingStairs(int[] cost, int[] dp, int i) {
        if(i == cost.length) return 0;
        if(i == cost.length - 1) return cost[cost.length - 1];

        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.min(minCostClimbingStairs(cost, dp, i + 1), minCostClimbingStairs(cost,  dp, i + 2)) + cost[i];
    }
}
