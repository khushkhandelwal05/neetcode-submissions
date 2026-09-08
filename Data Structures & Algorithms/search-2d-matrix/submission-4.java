class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        int mid1 = 0;
        while(s <= e) {
            mid1 = s - ((s - e) / 2);
            if(matrix[mid1][0] == target) {
                return true;
            } else if(target > matrix[mid1][0]) {
                if(target <= matrix[mid1][matrix[mid1].length - 1]) {
                    break;
                }
                s = mid1 + 1;
            } else {
                e = mid1 - 1;
            }
        }
        
        s = 0;
        e = matrix[mid1].length - 1;
        while(s <= e) {
            int mid = s - ((s - e) / 2);
            if(matrix[mid1][mid] == target) {
                return true;
            } else if(target > matrix[mid1][mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return false;
    }
}
