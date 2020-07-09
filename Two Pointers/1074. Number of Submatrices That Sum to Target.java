class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] presum = new int[n + 1][m + 1]; 
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                presum[i][j] = presum[i - 1][j] 
                    + presum[i][j - 1] 
                    - presum[i - 1][j - 1] 
                    + matrix[i - 1][j - 1];
            }
        }
        
        int count = 0;
        int sum = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int left = 1; left <= m; left++) {
            
            for (int right = left; right <= m; right++) {
                map.clear();
                map.put(0, 1);
                
                for (int r = 1; r <= n; r++) {
                    sum = presum[r][right] - presum[r][left - 1];
                    count += map.getOrDefault(sum - target, 0);
                    map.merge(sum, 1, Integer::sum);
                }
            }
        }
        return count;
    }
}
