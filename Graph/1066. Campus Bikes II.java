class Solution {
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[] dp = new int[1 << bikes.length];
        int res = dfs(workers, bikes, 0, 0, dp);
        return res;
    }
    
    private int dfs(int[][] workers, int[][] bikes, int used, int count, int[] dp) {
        if (count == workers.length) return 0;
        if (dp[used] > 0) return dp[used];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((used & (1 << i)) == 0) {
                used |= (1 << i); //set i th bit
                min = Math.min(min, dist(workers[count], bikes[i]) + dfs(workers, bikes, used, count+1, dp));
                used &= ~(1 << i); //unset i th bit
            }
            
        }
        return dp[used] = min;
    }
    
    private int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
