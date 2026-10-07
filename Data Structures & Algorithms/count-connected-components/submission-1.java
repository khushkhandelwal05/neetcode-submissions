class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] ed : edges) {
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }

        Set<Integer> vis = new HashSet<>();

        for(int i = 0 ; i < n ; i++) {
            if(!vis.contains(i)) {
                dfs(adj, i, vis, -1);
                count++;
            }
        }
        return count;
    }

    public void dfs(HashMap<Integer, List<Integer>> adj, int node, Set<Integer> vis, int prev) {
        if(vis.contains(node)) return;
        vis.add(node);
        if(adj.get(node).size() == 0) return;
        for(Integer i : adj.get(node)) {
            if(i != prev) {
                dfs(adj, i, vis, node);
            }
        }
        return;

    }
}
