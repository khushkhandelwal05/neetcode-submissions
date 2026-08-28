class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> dp = new ArrayList<>();
        List<Integer> A = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : candidates) {
            if(!map.containsKey(num)) A.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(A);
        backtrack(A,map, target, dp, 0);
        return ans;
    }

    public void backtrack(List<Integer> uNums,HashMap<Integer, Integer> map, int target, List<Integer> dp, int index) {
        if(target == 0) {
            ans.add(new ArrayList<>(dp));
            return;
        }

        if (target < 0) return;

        for(int i = index ; i < uNums.size() ;i++) {
            if(map.get(uNums.get(i)) != 0) {
                dp.add(uNums.get(i));
                map.put(uNums.get(i), map.get(uNums.get(i)) - 1);
                backtrack(uNums,map,target - uNums.get(i), dp, i);
                map.put(uNums.get(i), map.get(uNums.get(i)) + 1);
                dp.remove(dp.size() - 1);
            }
        }
    }
}
