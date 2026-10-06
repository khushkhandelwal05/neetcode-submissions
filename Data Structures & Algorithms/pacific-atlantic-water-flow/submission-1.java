class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> ant = new HashSet<>();
        boolean[][] visp = new boolean[heights.length][heights[0].length];
        boolean[][] visa = new boolean[heights.length][heights[0].length];

        for(int i = 0 ; i < heights.length ; i++) {
            for(int j = 0 ; j < heights[0].length ; j++) {
                if(i == 0 || j == 0) {
                    dfs(visp, heights, i, j, 0, pac);
                }
                if(i == heights.length - 1 || j == heights[0].length - 1) {
                    dfs(visa, heights, i, j, 0, ant);
                }
            }
        }

        Set<List<Integer>> unionSet = new HashSet<>(pac);
        unionSet.retainAll(ant);

        return new ArrayList<>(unionSet);
    }

    public void dfs(boolean[][] vis, int[][] heights, int i, int j, int prev, Set<List<Integer>> ocean) {
        if(i < 0 || j < 0 || j >= heights[0].length || i >= heights.length || vis[i][j] || heights[i][j] < prev) return;

        vis[i][j] = true;
        ocean.add(List.of(i, j));

        dfs(vis, heights, i + 1, j, heights[i][j], ocean);
        dfs(vis, heights, i, j + 1, heights[i][j], ocean);
        dfs(vis, heights, i - 1, j, heights[i][j], ocean);
        dfs(vis, heights, i, j - 1, heights[i][j], ocean);
    }
}