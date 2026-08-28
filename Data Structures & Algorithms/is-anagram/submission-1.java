class Solution {
    public boolean isAnagram(String s, String t) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0 ; i < s.length() ; i++) {
            char1[s.charAt(i) - 'a']++;
            char2[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26 ; i++){
            if(char1[i] != char2[i]) return false;
        }
        return true;
    }
}
