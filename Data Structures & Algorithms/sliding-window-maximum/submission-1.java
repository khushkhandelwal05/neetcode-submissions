class Solution {

    class Pair {
        int val;
        int ind;
        public Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        int[] res = new int[nums.length - k + 1];
        int a = 0;
        int b = 0;
        while(b < k) {
            pq.add(new Pair(nums[b], b));
            b++;
        }
        res[0] = pq.peek().val;
        int resCur = 1;
        a = 1;
        while(b < nums.length) {
            pq.add(new Pair(nums[b], b));
            while(pq.peek().ind < a) {
                pq.poll();
            }
            res[resCur++] = pq.peek().val;
            a++;
            b++;
        }
        return res;
    }
}
