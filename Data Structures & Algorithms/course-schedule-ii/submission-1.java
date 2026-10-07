class Solution {
    int count;
    public int[] findOrder(int cou, int[][] pre) {
        count = 0;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0 ; i < cou ; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] req : pre) {
            adj.get(req[0]).add(req[1]);
        }

        System.out.println(adj);

        Set<Integer> vis = new HashSet<>();
        Set<Integer> pathVis = new HashSet<>();
        int[] res = new int[cou];

        for(Map.Entry<Integer, List<Integer>> en : adj.entrySet()) {
            if(!vis.contains(en.getKey())) {
                if(!dfs(adj, vis, pathVis, res, en.getKey())) return new int[]{};
            }
        }

        return res;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> adj, Set<Integer> vis, Set<Integer> pathVis, int[] res, int node) {
        
        if(pathVis.contains(node)) return false;
        if(vis.contains(node)) return true;
        vis.add(node);
        pathVis.add(node);

        
        for(Integer i : adj.getOrDefault(node, new ArrayList<>())) {
            if(!dfs(adj, vis, pathVis, res, i)) return false;
        }

        res[count++] = node;
        pathVis.remove(node);
        return true;
    }
}
