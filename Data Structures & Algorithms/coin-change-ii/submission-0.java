class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length];
        for(int i = 0 ; i < amount + 1 ; i++) Arrays.fill(dp[i], -1);
        return change(amount, coins, 0);
    }

    public int change(int amount, int[] coins, int i) {
        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        if (dp[amount][i] != -1) return dp[amount][i];
        return dp[amount][i] = change(amount - coins[i] , coins, i) + change(amount, coins, i + 1);
    }
}
