class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
    for(int k = 0 ; k < s.length() ; k++) {
            int i = 0;
            int j = s.length() - k;
            while(j <= s.length()) {
                if(isPal(s.substring(i,j))) ans++;
                j++;
                i++;
            }
        }
        return ans;
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
