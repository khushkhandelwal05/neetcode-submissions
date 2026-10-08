class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Set<Integer> ty = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : hand) {
            ty.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> li = new ArrayList<>(ty);
        Collections.sort(li);

        for(int i = 0 ; i < li.size() ; i++) {
            while(map.get(li.get(i)) != 0){
                int cur = li.get(i);
                for(int j = 0 ; j < groupSize ; j++) {
                    if(map.getOrDefault(cur, 0) == 0) return false;
                    map.put(cur, map.get(cur) - 1);
                    cur += 1;
                }
            }
        }

        return true;
    }
}
