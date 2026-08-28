class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.getOrDefault(nums[i],new ArrayList<>()).add(i);
        }
        for(int i : nums) {
            int want = target - i;
            if(map.containsKey(want)) {
                if(want == i && map.get(want).size() > 1) {
                    return new int[]{map.get(want).get(0), map.get(want).get(1)};
                } else if(want == i) {
                    continue;
                }
                return new int[]{map.get(i).get(0), map.get(want).get(0)};
            }
        }
        return new int[]{0,0};
    }
}
