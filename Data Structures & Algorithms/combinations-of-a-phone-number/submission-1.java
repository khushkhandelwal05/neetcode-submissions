class Solution {
    List<String> ans = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return ans;
        
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "ABC");
        map.put('3', "DEF");
        map.put('4', "GHI");
        map.put('5', "JKL");
        map.put('6', "MNO");
        map.put('7', "PQRS");
        map.put('8', "TUV");
        map.put('9', "WXYZ");
        
        backtrack(digits, 0, map, new StringBuilder());
        return ans;
    }

    public void backtrack(String dig, int idx, HashMap<Character, String> map, StringBuilder sb) {
        if (idx == dig.length()) {
            ans.add(sb.toString().toLowerCase()); // convert final answer to lowercase if needed
            return;
        }

        String letters = map.get(dig.charAt(idx));
        for (int j = 0; j < letters.length(); j++) {
            sb.append(letters.charAt(j));
            backtrack(dig, idx + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
