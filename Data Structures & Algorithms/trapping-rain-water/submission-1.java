class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] rt = new int[height.length];
        int maxL = 0;
        int maxR = 0;
        for(int i = 0 ; i < height.length ; i++) {
            left[i] = maxL;
            rt[height.length - 1 - i] = maxR;
            maxL = Math.max(maxL, height[i]);
            maxR = Math.max(maxR, height[height.length - 1 - i]);
        }
        int tot = 0;
        for(int i = 0 ; i < height.length ; i++) {
            int add = Math.min(left[i], rt[i]) - height[i];
            if(add > 0) {
                tot += add;
            }
        }
        return tot;
    }
}
