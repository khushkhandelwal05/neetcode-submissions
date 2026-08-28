class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = currMax; // save old max before updating
            currMax = Math.max(nums[i], Math.max(nums[i] * currMax, nums[i] * currMin));
            currMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * currMin));
            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}
