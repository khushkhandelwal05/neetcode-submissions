class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int i = 0, j = 0;
        while(j < nums.length) {
            if(j - i + 1 < k){
                pq.add(nums[j++]);
                continue;
            }
            pq.add(nums[j]);
            ans[i] = pq.peek();
            pq.remove(nums[i]);
            i++;
            j++;
        }
        return ans;

    }
}
