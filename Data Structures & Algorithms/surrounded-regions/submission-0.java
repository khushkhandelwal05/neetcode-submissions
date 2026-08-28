class Solution {
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for(int r = 0 ; r < ROWS ; r++) {
            dfs(r, 0, board);
            dfs(r, COLS - 1, board);
        }

        for(int r = 0 ; r < COLS ; r++) {
            dfs(0, r, board);
            dfs(ROWS - 1, r, board);
        }

        for(int i = 0 ; i < ROWS ; i++) {
            for(int j = 0 ; j < COLS ; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
        
    }


    public void dfs(int r, int c, char[][] board) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;

        if(board[r][c] == 'X' || board[r][c] == 'T' ) return;
        if(board[r][c] == 'O') board[r][c] = 'T';

        for(int[] dir : dirs) {
            dfs(r + dir[0], c + dir[1], board);
        }
    }
}
