class KthLargest {

    PriorityQueue<Integer> pq;
    int maxCap;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        maxCap = k;
        for(int num : nums) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
            
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > maxCap){
            pq.poll();
        } 
        
        return pq.peek();
        
    }
}
