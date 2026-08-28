class Solution {
    public int[] findOrder(int num, int[][] edges) {
      Map<Integer, List<Integer>> adj = new HashMap<>();
      ArrayList<Integer> ans = new ArrayList<>();
        for (int[] e : edges) {
            if (e[1] == -1) continue;
            adj.computeIfAbsent(e[0], k -> new ArrayList<>()).add(e[1]);
        }
        boolean[] visited = new boolean[num];
        boolean[] inStack = new boolean[num];

        boolean hasCycle = false;
        for (int i = 0; i < num; i++) {
            if (!visited[i] && dfs(i, adj, visited, inStack, ans)) {
                return new int[0];
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++) res[i] = ans.get(i);
        return res;
    }

   static boolean dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, boolean[] inStack, ArrayList<Integer> ans) {
        visited[node] = true;
        inStack[node] = true;

        if (adj.containsKey(node)) {
            for (int nei : adj.get(node)) {
                if (!visited[nei] && dfs(nei, adj, visited, inStack, ans)) {
                    return true;
                } else if (inStack[nei]) {
                    return true; // cycle found
                }
            }
        }
        ans.add(node);

        inStack[node] = false; // backtrack
        return false;
    }
}
