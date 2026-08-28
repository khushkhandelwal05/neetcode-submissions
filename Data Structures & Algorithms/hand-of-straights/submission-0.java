class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        Arrays.sort(hand);
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int c : hand) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        for (int c : hand) {
            if (count.get(c) == 0) continue; // already used
            
            // try to form a group starting at c
            for (int j = 0; j < groupSize; j++) {
                int next = c + j;
                if (count.getOrDefault(next, 0) == 0) return false;
                count.put(next, count.get(next) - 1);
            }
        }
        return true;
    }
}
