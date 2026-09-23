class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word.toCharArray(), i, j, 0, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, char[] word, int i, int j, int k, boolean[][] vis) {
        if (k == word.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || vis[i][j] || board[i][j] != word[k]) {
            return false;
        }
        vis[i][j] = true;
        boolean found = dfs(board, word, i + 1, j, k + 1, vis) ||
                        dfs(board, word, i - 1, j, k + 1, vis) ||
                        dfs(board, word, i, j + 1, k + 1, vis) ||
                        dfs(board, word, i, j - 1, k + 1, vis);
        
        vis[i][j] = false;
        
        return found;
    }
}
