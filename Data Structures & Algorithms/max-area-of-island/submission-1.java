class Solution {

    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[i].length ; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max,maxAreaOfIsland(grid, i, j));
                }
            }
        }

        return max;
    }

    public int maxAreaOfIsland(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) return 0;
        int ans = 1;
        grid[i][j] = 0;
        for(int[] dir : dirs) {
            ans += maxAreaOfIsland(grid, i + dir[0], j + dir[1]);
        }

        return ans;
        
    }
}
