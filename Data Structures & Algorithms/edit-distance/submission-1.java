class Solution {

     private int[][] dp;
    public int minDistance(String word1, String word2) {

         int m = word1.length(), n = word2.length();
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(word1, word2, 0, 0, word1.length());
    }

    public int dfs(String word1, String word2, int i,int j, int size) {
        if(j == word2.length()) {
            if(i == word1.length()) return 0;
            return size - i;
        }

        if(i == word1.length()) {
            return word2.length() - j;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] =  dfs(word1, word2, i + 1,j + 1, word1.length());

        int res = Math.min(dfs(word1, word2, i + 1,j + 1, word1.length()), dfs(word1, word2, i + 1,j, word1.length() - 1));
        return dp[i][j] = 1 + Math.min(res, dfs(word1, word2, i ,j + 1, word1.length() + 1));
    }
}
