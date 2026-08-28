class Solution {
    Boolean[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return isInterleave(s1, s2, s3, 0,0,0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
        if(k == s3.length()) {
            if(i == s1.length() && j == s2.length()) return dp[i][j][k] = true;
            return  dp[i][j][k] = false;
        }
        if(i == s1.length() && j == s2.length()) return dp[i][j][k] = false;

        if(dp[i][j][k] != null)return dp[i][j][k];
        if (i == s1.length()) {
            if (s2.charAt(j) == s3.charAt(k)) return dp[i][j][k] = isInterleave(s1, s2, s3, i, j + 1, k + 1);
            return dp[i][j][k] = false;
        } else if (j == s2.length()) {
            if (s1.charAt(i) == s3.charAt(k)) return dp[i][j][k] = isInterleave(s1, s2, s3, i + 1, j, k + 1);
            return dp[i][j][k] = false;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            if(s1.charAt(i) == s3.charAt(k)) return dp[i][j][k] = isInterleave(s1, s2, s3, i + 1, j, k + 1) || isInterleave(s1, s2, s3, i, j + 1, k + 1);
            return dp[i][j][k] = false;
        }

        if (s1.charAt(i) == s3.charAt(k)) {
            return dp[i][j][k] = isInterleave(s1, s2, s3, i + 1, j, k + 1);
        }

        if (s2.charAt(j) == s3.charAt(k)) {
            return dp[i][j][k] = isInterleave(s1, s2, s3, i, j + 1, k + 1);
        }

        return false;
    }
}
