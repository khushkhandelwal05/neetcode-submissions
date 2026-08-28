class KthLargest {

    PriorityQueue<Integer> pq;
    int maxCap;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        maxCap = k;
        for(int num : nums) {
            if(pq.size() == k) {
                if(num < pq.peek()) continue;
                pq.poll();
            }
            pq.add(num);
        }
    }
    
    public int add(int val) {
        if(pq.size() == maxCap){
            if(val < pq.peek()) return pq.peek();
            pq.poll();
        } 
        pq.add(val);
        return pq.peek();
        
    }
}
