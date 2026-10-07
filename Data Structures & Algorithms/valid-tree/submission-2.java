class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0 && n == 1) return true;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] ed : edges) {
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }

        Set<Integer> vis = new HashSet<>();   
        if(!dfs(adj, 0, vis, -1)) return false;

        if(vis.size() != n) return false;
        return true;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> adj, int node, Set<Integer> vis, int prev) {
        if(vis.contains(node)) return false;

        vis.add(node);

        if(adj.get(node).size() == 0) return false;

        for(Integer i : adj.get(node)) {
            if(i != prev) {
                if(!dfs(adj, i, vis, node)) return false;
            }
        }

        return true;

    }
}
