class Solution {
    public int maxArea(int[] he) {
        int ans = 0;
        int i = 0;
        int j = he.length - 1;
        while(i < j) {
            int volc = vol(j - i, he[i], he[j]);
            ans = Math.max(ans, volc);
            if (he[i] > he[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
    public int vol(int dist, int h1, int h2) {
        int min = Math.min(h1,h2);
        return dist * min;
    }
}
