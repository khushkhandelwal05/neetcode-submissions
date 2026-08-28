class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String s : strs) {
            int[] chars = new int[26];
            for(char c : s.toCharArray()) {
                chars[c - 'a']++;
            }
            String str = Arrays.toString(chars);
            if(map.containsKey(str)) {
                int ind = map.get(str);
                ans.get(ind).add(s);
            } else {
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(s);
                map.put(str, ans.size() - 1);
            }
        }

        return ans;
    }
}
