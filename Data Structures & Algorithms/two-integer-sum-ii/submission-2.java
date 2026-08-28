class Solution {
    public int[] twoSum(int[] num, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = num.length - 1;
        while(i < j) {
            if(num[i] + num[j] > target) {
                j--;
            } else if (num[i] + num[j] < target) {
                i++;
            } else {
                return new int[]{i + 1,j + 1};
            }
        }
        return res;
    }
}
