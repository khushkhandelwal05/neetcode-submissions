class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build the adjacency list correctly
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            
            // Fix: computeIfAbsent safely instantiates the list if it doesn't exist
            adj.computeIfAbsent(course, k -> new ArrayList<>()).add(prerequisite);
        }

        // Global visited set to avoid re-checking fully processed components
        Set<Integer> visited = new HashSet<>();
        // Set to track the active DFS path (for cycle detection)
        Set<Integer> pathVisited = new HashSet<>();

        // 2. Loop through all nodes in the graph
        for (int course : adj.keySet()) {
            if (!visited.contains(course)) {
                if (hasCycle(adj, visited, pathVisited, course)) {
                    return false; // Cycle found, cannot finish courses
                }
            }
        }

        return true;
    }

    private boolean hasCycle(HashMap<Integer, ArrayList<Integer>> adj, 
                             Set<Integer> visited, Set<Integer> pathVisited, int current) {
        
        // If it's in the current path, we found a cycle!
        if (pathVisited.contains(current)) return true;
        // If we already fully processed this node in a past path, it's safe
        if (visited.contains(current)) return false;

        // Actively processing this node
        pathVisited.add(current);
        visited.add(current);

        // Traverse neighbors
        if (adj.containsKey(current)) {
            for (int neighbor : adj.get(current)) {
                if (hasCycle(adj, visited, pathVisited, neighbor)) {
                    return true;
                }
            }
        }

        // Backtrack: remove from current path execution
        pathVisited.remove(current);
        return false;
    }
}
