class Solution {
    List<List<String>> ans  = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }


    public void backtrack(String s, int idx, List<String> curr) {
        if(idx == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx + 1 ; i <= s.length(); i++) {
            if(isPal(s.substring(idx,i))) {
                curr.add(s.substring(idx,i));
                backtrack(s, i, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPal(String s) {
        int i = 0;
        int j = s.length() -1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;

    }
}
