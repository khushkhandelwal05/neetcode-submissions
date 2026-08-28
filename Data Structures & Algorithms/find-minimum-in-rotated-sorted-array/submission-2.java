class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int least = 1001;
        while (s <= e) {
            if (nums[s] <= nums[e]) {
                least = Math.min(least,nums[s]);
                break;
            }
            int mid = s + ((e - s )/ 2);
            least = Math.min(least,nums[mid]);
            if (nums[mid] >= nums[s]){
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return least;
    }
}
