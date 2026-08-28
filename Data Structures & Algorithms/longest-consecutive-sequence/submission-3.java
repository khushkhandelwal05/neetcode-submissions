class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        int max = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int cur = nums[i];
            int curMax = 0;
            while(set.contains(cur)) {
                set.remove(cur);
                curMax++;
                cur++;
            }
            cur = nums[i];
            while(set.contains(cur - 1)) {
                set.remove(cur- 1);
                curMax++;
                cur--;
            }
            max = Math.max(max, curMax);
        }
        return max;
    }
}
