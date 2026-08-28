class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        System.out.println(map);
        Set<Integer> vis = new HashSet<>();
        if(dfs(0, -1,map, vis)){
            System.out.println(vis);
            return false;
        }
        System.out.println(vis);
        if(vis.size() != n) return false;


        return true;
    }

   static boolean dfs(int node, int parent, Map<Integer, List<Integer>> adj, Set<Integer> vis) {
        vis.add(node);

        if (adj.containsKey(node)) {
            for (int nei : adj.get(node)) {
                if (!vis.contains(nei)) {
                    if (dfs(nei, node, adj, vis)) {
                        return true;
                    }
                } else if (nei != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
