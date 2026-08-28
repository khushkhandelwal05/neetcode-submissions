class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] mat) {
        int[][] mat2 = new int[mat.length + 2][mat[0].length + 2];
        for(int i = 0 ; i < mat2.length; i++) {
            for(int j = 0 ; j < mat2[i].length; j++){
                if(i == 0 || j == 0 || i == mat2.length - 1 || j == mat2[0].length - 1){
                    mat2[i][j] = Integer.MIN_VALUE;
                } else {
                    mat2[i][j] = mat[i - 1][j - 1];
                } 
            }
        }

        dp = new int[mat2.length][mat2[0].length];
        for(int i = 0 ; i < dp.length ; i++) Arrays.fill(dp[i], -1);

        int ans = 0;
        for(int i = 1 ; i < mat2.length - 1; i++) {
            for(int j = 1 ; j < mat2[i].length - 1; j++) {
                ans = Math.max(ans, longestIncreasingPath(mat2, i, j));
            }
        }
        return ans;
    }

    public int longestIncreasingPath(int[][] m, int i, int j) {
        int res = 1;
        if(dp[i][j] != -1) return dp[i][j];
        if (m[i + 1][j] > m[i][j]) res = Math.max(res, 1 + longestIncreasingPath(m, i + 1, j));
        if (m[i - 1][j] > m[i][j]) res = Math.max(res, 1 + longestIncreasingPath(m, i - 1, j));
        if (m[i][j + 1] > m[i][j]) res = Math.max(res, 1 + longestIncreasingPath(m, i, j + 1));
        if (m[i][j - 1] > m[i][j]) res = Math.max(res, 1 + longestIncreasingPath(m, i, j - 1));
        return dp[i][j] = res;
    }
}
