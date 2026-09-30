class Solution {
    int ROWS, COLS;
    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int fresh = 0;
        boolean[][] vis = new boolean[ROWS][COLS];

        Queue<int[]> qu = new LinkedList<>();

        for(int i = 0 ; i < ROWS ; i++) {
            for(int j = 0 ; j < COLS ; j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) {
                    add(vis, qu, grid, i, j);
                }
            }
        }
        int min = 0;

        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i = 0 ; i < size ; i++) {
                int[] val = qu.poll();
                if(add(vis, qu, grid, val[0] + 1, val[1])) fresh--;
                if(add(vis, qu, grid, val[0] - 1, val[1])) fresh--;
                if(add(vis, qu, grid, val[0], val[1] + 1)) fresh--;
                if(add(vis, qu, grid, val[0], val[1] - 1)) fresh--;
            }
            if(!qu.isEmpty()) min++;
        }

        if(fresh == 0) return min;
        return -1;
    }

    public boolean add(boolean[][] vis, Queue<int[]> qu, int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) return false;
        qu.add(new int[]{i, j});
        vis[i][j] = true;
        return true;
    }
}
