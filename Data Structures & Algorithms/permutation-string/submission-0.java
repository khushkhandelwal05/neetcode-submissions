class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if (s2.length() < k) return false;

        int val = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();

        // Build frequency map for s1
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map1.containsKey(c)) {
                val++;
            }
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;

        while (j < s2.length()) {
            char c = s2.charAt(j);

            // expand window
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) - 1);
                if (map1.get(c) == 0) {
                    val--;
                }
            }

            // if window size == k, check result
            if (j - i + 1 == k) {
                if (val == 0) return true;

                // shrink from left
                char left = s2.charAt(i);
                if (map1.containsKey(left)) {
                    if (map1.get(left) == 0) {
                        val++;
                    }
                    map1.put(left, map1.get(left) + 1);
                }
                i++;
            }
            j++;
        }

        return false;
    }
}
