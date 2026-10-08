class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        for (int card : map.keySet()) {
            int count = map.get(card);
            if (count > 0) {
                // Try to form a group of size `groupSize` starting from `card`
                for (int i = 0; i < groupSize; i++) {
                    int currentCard = card + i;
                    if (map.getOrDefault(currentCard, 0) < count) {
                        return false;
                    }
                    map.put(currentCard, map.get(currentCard) - count);
                }
            }
        }

        return true;
    }
}
