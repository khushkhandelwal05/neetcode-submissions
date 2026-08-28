class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] l = s.toCharArray();
            Arrays.sort(l);
            String wo = new String(l);
            if(!map.containsKey(wo)) {
                map.put(wo, new ArrayList<>());
            }
            map.get(wo).add(s);
        }
        List<List<String>> li = new ArrayList<>();
        map.forEach((key, value) -> {
            li.add(value);
        });
        return li;

    }
}
