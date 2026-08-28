class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] e : edges) {
            if(!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            if(!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            if(!vis.contains(i)) {
                ans++;
                dfs(i,map, vis);
            }
            
        }
        return ans;
    }

   static void dfs(int node, Map<Integer, List<Integer>> adj, Set<Integer> vis) {
        vis.add(node);

        if (adj.containsKey(node)) {
            for (int nei : adj.get(node)) {
                if (!vis.contains(nei)) {
                    dfs(nei, adj, vis);
                } 
            }
        }
    }
}
