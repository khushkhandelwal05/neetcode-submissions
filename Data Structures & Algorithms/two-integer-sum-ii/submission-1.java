class Solution {
    public int[] twoSum(int[] n, int target) {
        int i = 0;
        int j = n.length - 1;
        while (i < j) {
            int s = n[i] + n[j];
            if (s == target) {
                return new int[]{i+1,j+1};
            } else if (s > target){
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
}
