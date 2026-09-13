class Solution {

    public int maxChar(int[] ch) {
        int max = 0;
        for(int c : ch) {
            max = Math.max(max, c);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int a = 0;
        int b = 0;
        int maxL = 0;
        int[] ch = new int[26];
        while(b < s.length()) {
            ch[s.charAt(b) - 'A']++;
            int maxC = maxChar(ch);
            int rem = b - a + 1 - maxC;
            while(b >= a && rem > k) {
                ch[s.charAt(a) - 'A']--;
                a++;
                maxC = maxChar(ch);
                rem = b - a - maxC;
            }
            maxL = Math.max(maxL, b - a + 1);
            b++;
        }
        return maxL;
    }
}
