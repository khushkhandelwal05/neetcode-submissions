class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        int i = 0;
        while(i < s.length()) {
            Set<Character> ch = new HashSet<>();
            ch.add(s.charAt(i));
            int curr = 0;
            while(ch.size() != 0) {
                if(map.get(s.charAt(i)) == 1) {
                    ch.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    ch.add(s.charAt(i));
                }
                curr++;
                i++;
            }
            ans.add(curr);
        }
        return ans;
    }
}
