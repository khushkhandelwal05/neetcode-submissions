class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int max = nums[0];

        for(int i = 0 ; i < nums.length ; i++) {
            if(curMax < 0) {
                curMax = 0;
            }
            curMax += nums[i];
            max = Math.max(max, curMax);
        }
        return max;
    }
}
