class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> qu = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 2) {
                    qu.add(new int[]{i,j});
                }
                 if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!qu.isEmpty() && fresh > 0) {
            int length = qu.size();
            for (int i = 0; i < length; i++) {
                int[] node = qu.poll();
                int row = node[0];
                int col = node[1];
                for(int[] dir : dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || grid[r][c] == 2) continue;
                    grid[r][c] = 2;
                    qu.add(new int[]{r,c});
                    fresh--;
                }
            }
            time++;
        }

        return fresh == 0 ? time: -1;
    }
}
