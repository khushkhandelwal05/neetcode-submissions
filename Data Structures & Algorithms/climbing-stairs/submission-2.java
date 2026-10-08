class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        for(int i = 0 ; i < n ; i++) {
            dp[i] = -1;
        }

        return climb(0, n, dp);
    }

    public int climb(int i, int n, int[] dp) {
        if(i == n - 1) return 1;
        if(i == n - 2) return 2;
        if(dp[i] != -1) return dp[i];

        return dp[i] = climb(i + 1, n, dp) + climb(i + 2, n, dp);
    }
}
