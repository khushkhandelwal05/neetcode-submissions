class Solution {
    public boolean canFinish(int num, int[][] edges) {


        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : edges) {
            if (e[1] == -1) continue;
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        boolean[] visited = new boolean[num];
        boolean[] inStack = new boolean[num];

        boolean hasCycle = false;
        for (int i = 0; i < num; i++) {
            if (!visited[i] && dfs(i, adj, visited, inStack)) {
                return false;
            }
        }

        return true;
    }

   static boolean dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, boolean[] inStack) {
        visited[node] = true;
        inStack[node] = true;

        if (adj.containsKey(node)) {
            for (int nei : adj.get(node)) {
                if (!visited[nei] && dfs(nei, adj, visited, inStack)) {
                    return true;
                } else if (inStack[nei]) {
                    return true; // cycle found
                }
            }
        }

        inStack[node] = false; // backtrack
        return false;
    }
}
