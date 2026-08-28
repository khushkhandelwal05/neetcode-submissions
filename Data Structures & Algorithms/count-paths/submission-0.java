class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int i = 0 ; i < dp.length ; i++) Arrays.fill(dp[i], -1);
        return dfs(m, n);
    }

    public int dfs(int m, int n) {
        if(m == 1 || n == 1) return dp[m][n] = 1;

        if(dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = dfs(m - 1,n) + dfs(m, n-1);
    }
}
