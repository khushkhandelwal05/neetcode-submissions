class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    res++;
                    island(grid, vis, i, j);
                }
            }
        }
        return res;
    }

    public void island(char[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if(vis[i][j]) return;
        if(grid[i][j] == '0') return;
        vis[i][j] = true;
        island(grid, vis, i + 1, j);
        island(grid, vis, i, j + 1);
        island(grid, vis, i - 1, j);
        island(grid, vis, i, j - 1);
    }
}
