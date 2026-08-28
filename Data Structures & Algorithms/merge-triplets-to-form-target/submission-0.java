class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for(int i = 0 ; i < triplets.length - 1; i++) {
            boolean ch = true;
            int[] curr = new int[3];
            for(int j = 0 ; j < 3 ; j++) {
                if(triplets[i][j] <= target[j]) {
                    if(triplets[i + 1][j] <= target[j]) {
                        curr[j] = Math.max(triplets[i + 1][j], triplets[i][j]);
                    } else {
                        triplets[i + 1] = triplets[i];
                        ch = false;
                        break;
                    }
                } else {
                    ch = false;
                    break;
                }
            }
            if(ch) {
                triplets[i + 1] = curr;
            }
        }
        return Arrays.equals(triplets[triplets.length - 1], target);
    }
}
