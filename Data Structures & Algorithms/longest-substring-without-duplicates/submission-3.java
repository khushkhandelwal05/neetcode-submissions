class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        int b = 0;
        int currentSize = 0;
        int size = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(!map.getOrDefault(s.charAt(i), false)) {
                map.put(s.charAt(i), true);
                currentSize++;
            } else {
                while(s.charAt(b) != s.charAt(i)) {
                    map.put(s.charAt(b), false);
                    b++;
                }
                b++;
                currentSize = i - b + 1;
            }
            size = Math.max(currentSize, size);
        }
        return size;
    }
}
