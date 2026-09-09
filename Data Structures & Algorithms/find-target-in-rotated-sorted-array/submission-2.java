class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s < e) {
            int mid = s + ((e - s) / 2);
            if(nums[mid] > nums[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        int min = nums[s];
        if(target >= min && target <= nums[nums.length - 1]) {
            e = nums.length - 1;
        } else {
            if(s == 0) return -1;
            e = s - 1;
            s = 0;
        }
        while (s <= e) {
            int mid = s + ((e - s) / 2);
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
