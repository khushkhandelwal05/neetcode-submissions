class Solution {
    int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int i = 0 ; i < ROWS ; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if(board[i][COLS - 1] == 'O') {
                dfs(i, COLS - 1, board);
            }
        }


        for(int i = 0 ; i < COLS ; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if(board[ROWS - 1][i] == 'O') {
                dfs(ROWS - 1,i, board);
            }
        }

        for(int i = 0 ; i < ROWS ; i++) {
            for(int j = 0 ; j < COLS ; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board) {
        if(i < 0 || j < 0 || i >= ROWS || j >= COLS || board[i][j] != 'O') return;

        board[i][j] = 'A';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
