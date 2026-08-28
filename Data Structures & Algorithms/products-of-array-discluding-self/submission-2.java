class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int current = 1;
        for(int i = 0 ; i < nums.length ; i++) {
            res[i] = current;
            current = current * nums[i];
        }
        current = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            res[i] = current * res[i];
            current = current * nums[i];
        }
        return res;
    }
}  
