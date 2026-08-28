class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == "") return ans;
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList("A","B","C")));
        map.put('3', new ArrayList<>(Arrays.asList("D","E","F")));
        map.put('4', new ArrayList<>(Arrays.asList("G","H","I")));
        map.put('5', new ArrayList<>(Arrays.asList("J","K","L")));
        map.put('6', new ArrayList<>(Arrays.asList("M","N","O")));
        map.put('7', new ArrayList<>(Arrays.asList("P","Q","R","S")));
        map.put('8', new ArrayList<>(Arrays.asList("T","U","V")));
        map.put('9', new ArrayList<>(Arrays.asList("W","X","Y","Z")));
        backtrack(digits, 0, map, new StringBuilder());
        return ans;
    }

    public void backtrack(String dig, int idx, HashMap<Character, ArrayList<String>> map, StringBuilder sb) {
        if(idx == dig.length()) {
            ans.add(sb.toString());
            return;
        }


        ArrayList<String> list = map.get(dig.charAt(idx));
        for(int j = 0 ; j < list.size() ; j++ ){
            sb.append(list.get(j).toLowerCase());
            backtrack(dig, idx + 1, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
