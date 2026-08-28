class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)){
                li.add(num);
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
            
        }
        System.out.println(map);
        System.out.println(li);
        backtrack(li, map, new ArrayList<>(), 0);
        return ans;
    }

    public void backtrack(List<Integer> li, HashMap<Integer, Integer> map, List<Integer> dp, int idx) {

        ans.add(new ArrayList(dp));

        for(int i = idx ; i < li.size() ; i++) {
            if(map.get(li.get(i)) != 0) {
                map.put(li.get(i), map.get(li.get(i)) - 1);
                dp.add(li.get(i));
                backtrack(li, map, dp, i);
                map.put(li.get(i), map.get(li.get(i)) + 1);
                dp.remove(dp.size() - 1);
            }
        }
    }
}
