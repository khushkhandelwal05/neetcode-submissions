class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        int mid = 0;
        while(s <= e) {
            mid = s + ((e - s) / 2);
            if (matrix[mid][0] == target) {
                return true;
            }else if (matrix[mid][0] > target) {
                e = mid - 1;
            } else if(matrix[mid][0] < target) {
               s = mid + 1;
            }
        }
        if (e < 0) return false;
        int top = 0;
        int bot = matrix[e].length - 1;
        while(top <= bot) {
            mid = top + ((bot - top)/ 2);
            if (matrix[e][mid] == target) {
                return true;
            } else if(matrix[e][mid] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return false;
    }
}
