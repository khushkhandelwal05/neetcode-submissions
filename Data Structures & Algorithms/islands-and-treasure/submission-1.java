class Solution {



    public void islandsAndTreasure(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> qu = new LinkedList<>();

        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 0) {
                    qu.add(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }
        int dist = 0;
        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int i = 0 ; i < size ; i++) {
                int[] val = qu.poll();
                grid[val[0]][val[1]] = dist;
                int k = val[0];
                int j = val[1];
                add(grid, qu, vis, k + 1, j);
                add(grid, qu, vis, k - 1, j);
                add(grid, qu, vis, k, j + 1);
                add(grid, qu, vis, k, j - 1);
            }
            dist++;
        }
    }

    public void add(int[][] grid, Queue<int[]> qu, boolean[][] vis, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == -1) return;
        vis[i][j] = true;
        qu.add(new int[]{i , j});
    }
}
