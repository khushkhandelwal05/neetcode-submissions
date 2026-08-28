class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Build adjacency map (graph)
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    Set<String> wordSet = new HashSet<>(wordList);

    if (!wordSet.contains(endWord)) return 0;

    // Construct adjacency list
    for (String word : wordSet) {
        map.put(word, new ArrayList<>());
    }
    map.putIfAbsent(beginWord, new ArrayList<>());

    for (String w1 : map.keySet()) {
        for (String w2 : map.keySet()) {
            if (isOneCharDiff(w1, w2)) {
                map.get(w1).add(w2);
                map.get(w2).add(w1); // undirected edges
            }
        }
    }

    // BFS
    Queue<String> q = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    q.add(beginWord);
    vis.add(beginWord);

    int steps = 1; // start word counts as step 1

    while (!q.isEmpty()) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            String curr = q.poll();
            if (curr.equals(endWord)) {
                return steps;
            }
            for (String nei : map.get(curr)) {
                if (!vis.contains(nei)) {
                    vis.add(nei);
                    q.add(nei);
                }
            }
        }
        steps++;
    }

    return 0; // no path
}

private boolean isOneCharDiff(String a, String b) {
    if (a.length() != b.length()) return false;
    int diff = 0;
    for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
            diff++;
            if (diff > 1) return false;
        }
    }
    return diff == 1;
}

}
