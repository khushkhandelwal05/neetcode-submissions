class Solution {
    public String longestPalindrome(String s) {
        for(int k = 0 ; k < s.length() ; k++) {
            int i = 0;
            int j = s.length() - k;
            while(j <= s.length()) {
                if(isPal(s.substring(i,j))) return s.substring(i,j);
                j++;
                i++;
            }
        }
        return "";
    }

    public boolean isPal(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
