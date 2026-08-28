class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -2); // use -2 to mark "not computed"
        }
        return coinChange(coins, amount, coins.length - 1, dp);
    }

    public int coinChange(int[] coins, int amt, int idx, int[][] dp) {
        if (amt == 0) return 0;
        if (amt < 0 || idx < 0) return -1;
        if (dp[idx][amt] != -2) return dp[idx][amt];

        // Option 1: take current coin
        int val1 = coinChange(coins, amt - coins[idx], idx, dp);
        // Option 2: skip current coin
        int val2 = coinChange(coins, amt, idx - 1, dp);

        int ans = -1;
        if (val1 == -1 && val2 == -1) {
            ans = -1;
        } else if (val1 == -1) {
            ans = val2;
        } else if (val2 == -1) {
            ans = 1 + val1;
        } else {
            ans = Math.min(1 + val1, val2);
        }

        return dp[idx][amt] = ans;
    }
}
