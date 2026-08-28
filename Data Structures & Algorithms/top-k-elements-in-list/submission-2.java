class Solution {
    class Pair {
        int val;
        int count;
        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> b.count - a.count);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        System.out.println(map);
        map.forEach((key, value) -> {
            heap.add(new Pair(key, value));
        });
        int[] res = new int[k];
        for (int i = 0 ; i < k ; i++) {
            res[i] = heap.poll().val;
        }
        return res;
    }
}
