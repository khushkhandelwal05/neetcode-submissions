class Solution {
    public int trap(int[] height) {
        int[] pre = new int[height.length];
        int preMax = 0;
        int sufMax = 0;
        int[] suf = new int[height.length];
        int j = height.length - 1;
        for (int i = 0 ; i < height.length ; i++) {
            pre[i] = Math.max(preMax, height[i]);
            preMax = pre[i];
            suf[j] = Math.max(sufMax, height[j]);
            sufMax = suf[j];
            j--;
        }
        int tot = 0;
        for (int i = 0 ; i < height.length ; i++) {
            tot += Math.min(pre[i], suf[i]) - height[i];
        }
        return tot;
    }
}
