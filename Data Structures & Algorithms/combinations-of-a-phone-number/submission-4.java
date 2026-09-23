class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        List<Character> sub = new ArrayList<>();
        map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));
        List<String> res = new ArrayList<>();
        char[] dig = digits.toCharArray();
        dfs(dig, 0, map, sub, res);
        return res;
    }


    public void dfs(char[] dig, int i, HashMap<Character, List<Character>> map, List<Character> sub, List<String> res) {
        if(i == dig.length) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : sub) {
                sb.append(ch);
            }
            String result = sb.toString();
            if(result.length() > 0) res.add(result);
            return;
        }
        for(Character ch : map.get(dig[i])) {
            sub.add(ch);
            dfs(dig, i + 1, map, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
