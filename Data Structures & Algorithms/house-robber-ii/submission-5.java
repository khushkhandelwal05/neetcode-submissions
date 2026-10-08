class Solution {
    public int rob(int[] cost) {
        boolean first = false;
        int n = cost.length;
        int[][] dp = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return Math.max(cost[0] + climb(2, cost, dp, true), climb(1, cost, dp, false));
    }

    public int climb(int i, int[] cost, int[][] dp,boolean first) {
        if(i == cost.length - 1 && first) return 0;
        if(i >= cost.length) return 0;
        if(first && dp[i][0] != -1) return dp[i][0];
        if(!first && dp[i][1] != -1) return dp[i][1];

        if (first) return dp[i][0] = Math.max(climb(i + 1, cost, dp, first),cost[i] + climb(i + 2, cost, dp, first));
        return dp[i][1] = Math.max(climb(i + 1, cost, dp, first),cost[i] + climb(i + 2, cost, dp, first));
    }
}
