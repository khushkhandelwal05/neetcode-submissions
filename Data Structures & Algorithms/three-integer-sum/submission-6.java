class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                List<Integer> temp = new ArrayList<>();
                int sum = nums[j] + nums[k];
                if(sum > target) {
                    k--;
                } else if(sum < target) {
                    j++;
                } else {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                    j++;
                }
                if(temp.size() > 0){
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
