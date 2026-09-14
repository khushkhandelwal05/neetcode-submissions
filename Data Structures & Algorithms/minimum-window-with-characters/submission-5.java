class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> tch = new HashMap<>();
        HashMap<Character, Integer> sch = new HashMap<>();
        int sat = 0;
        int need = 0;
        for(char c : t.toCharArray()) {
            if (tch.getOrDefault(c, 0) == 0) need++;
            tch.put(c, tch.getOrDefault(c, 0) + 1);
        }
        int a = -1;
        for(int i = 0 ; i < s.length() ; i++) {
             if(tch.containsKey(s.charAt(i))) {
                a = i;
                break;
             }
        }
        if (a == -1) return "";
        int b = a;
        int bestStart = -1, bestLen = Integer.MAX_VALUE;
        while(b < s.length()) {
            char cb = s.charAt(b);
            sch.put(cb, sch.getOrDefault(cb, 0) + 1);
            if(tch.getOrDefault(cb, 0) > 0 && sch.get(cb).intValue() == tch.get(cb).intValue()) sat++;
            while(sat == need) {
                if (b - a + 1 < bestLen) {
                    bestLen = b - a + 1;
                    bestStart = a;
                }
                char ca = s.charAt(a);
                sch.put(ca, sch.get(ca) - 1);
                if(tch.getOrDefault(ca, 0) > 0 && sch.get(ca) < tch.get(ca)) sat--;
                a++;
            }
            b++;
        }
        return bestStart == -1 ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}