class Solution {

    /** from the top-right corner
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
    
    /** binary search
    */
    class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix.length == 0 || matrix[0].length == 0) return false;
	
        int begin = 0;
        int end = matrix.length * matrix[0].length - 1;

        while(begin <= end){
            int mid = (begin + end) / 2;
            int mid_val = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if( mid_val == target) return true;
            else if(mid_val < target) begin = mid+1;
            else end = mid-1;
        }

        return false;
        }
}
    
}
