class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b) -> b - a);
        for(int num : stones) pq.add(num);

        while(pq.size() > 1) {
            pq.add(Math.abs(pq.poll() - pq.poll()));
        }
        return pq.poll();
    }
}
