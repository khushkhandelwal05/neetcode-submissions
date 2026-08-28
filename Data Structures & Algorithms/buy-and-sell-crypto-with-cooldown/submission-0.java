class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {

        dp = new int[prices.length + 2][prices.length + 2];
        for(int i = 0 ; i < dp.length ; i++) Arrays.fill(dp[i], -1);
        return maxProfit(prices, 0, 0);
    }

    public int maxProfit(int[] prices, int i, int j) {
        if(i >= prices.length || j >= prices.length ) return dp[i][j] = 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i == j) {
            return dp[i][j] = Math.max(maxProfit(prices, i, j + 1), maxProfit(prices, i + 1, j + 1));
        }

        return dp[i][j] = Math.max(maxProfit(prices, j + 2, j + 2) + prices[j] - prices[i], maxProfit(prices, i, j + 1));


        
    }
}
