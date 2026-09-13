class Solution {
    public int maxProfit(int[] prices) {
        int s = 0;
        int profit = 0;
        for(int i = 1 ; i < prices.length ; i++) {
            if(prices[i] - prices[s] > 0) {
                profit = Math.max(profit, prices[i] - prices[s]);
            } else {
                s = i;
            }
        }
        return profit;
    }
}
