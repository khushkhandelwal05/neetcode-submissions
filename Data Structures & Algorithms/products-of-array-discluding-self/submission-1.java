class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] ans = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            if(i == 0) {
                ans[i] = 1;
            } else {
                ans[i] = prod;
            }
            prod = prod * nums[i];
        }

        prod = 1;
        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            if(i != nums.length - 1) {
                ans[i] = ans[i] * prod;
            }
            prod = prod * nums[i];
        }

        return ans;
    }
}  
