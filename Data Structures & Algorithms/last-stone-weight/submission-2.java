class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i : stones) {
            pq.add(i);
        }
        while(pq.size() > 1) {
            int st = pq.poll() - pq.poll();
            if(st == 0) {
                if(pq.size() == 0) {
                    pq.add(st);
                }
            } else {
                pq.add(st);
            }
        }
        return pq.poll();
    }
}
