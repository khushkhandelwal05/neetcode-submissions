class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] incNums = new int[nums.length];
        int[] excNums = new int[nums.length];
        int[] ans = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            if (i == 0) {
                incNums[i] = 1;
                excNums[nums.length - 1] = 1;
                continue;
            }
            incNums[i] = nums[i - 1] *  incNums[i - 1];
            excNums[nums.length - 1 - i] = nums[nums.length - i] *  excNums[nums.length - i];
        }
        for (int i = 0 ; i < nums.length ; i++) {
            ans[i] = incNums[i] * excNums[i];
        } 
        return ans;
    }
}  
