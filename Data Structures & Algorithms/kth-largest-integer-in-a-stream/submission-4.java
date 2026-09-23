class KthLargest {

    PriorityQueue<Integer> pq;
    int cap;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b) -> a - b);
        cap = k;
        for(int i : nums) {
            if(cap <= 0) {
                if(i >= pq.peek()) {
                    pq.poll();
                    pq.add(i);
                }
            } else {
                pq.add(i);
                cap--;
            }
        }
    }
    
    public int add(int val) {
        if(cap <= 0) {
            if(val >= pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        } else {
            pq.add(val);
            cap--;
        }
        return pq.peek();
    }
}
