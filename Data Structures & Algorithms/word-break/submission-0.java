class Solution {
    Set<String> wordSet;
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];
        return dfs(s, 0);
    }

    private boolean dfs(String s, int start) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && dfs(s, end)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
}
