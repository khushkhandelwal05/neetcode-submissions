class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!checkIfAlphanumeric(s.charAt(i))) {
                i++;
                continue;
            }
            if (!checkIfAlphanumeric(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean checkIfAlphanumeric(char character){
      if ((character >= '0' & character <= '9') || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')){
        return true;
      }else{
        return false;
      }
    }
}
