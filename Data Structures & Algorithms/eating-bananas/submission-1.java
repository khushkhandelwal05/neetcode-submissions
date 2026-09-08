class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max =0;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        int s =1;
        int e = max;
        int mid = 0;
        int res = 1;
        while(s <= e){
            mid = s + ((e - s) / 2);
            int tot = 0;
            for(int i : piles) {
                tot += (int)Math.ceil((double)i / mid);
                if(tot > h) break;
            }
            if (tot > h){
                s = mid + 1;
            } else {
                res = mid;
                e = mid - 1;
            }
        }
        return res;
    }
}
