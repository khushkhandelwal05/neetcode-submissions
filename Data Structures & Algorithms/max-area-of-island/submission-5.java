class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(!vis[i][j] && grid[i][j] == 1){
                    int area = tot(grid, vis, i, j);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    public int tot(int[][] grid, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0) return 0;
        vis[i][j] = true;
        return 1 + tot(grid, vis, i + 1, j) + tot(grid, vis, i, j + 1) + tot(grid, vis, i - 1, j) + tot(grid, vis, i, j - 1);
    }
}
