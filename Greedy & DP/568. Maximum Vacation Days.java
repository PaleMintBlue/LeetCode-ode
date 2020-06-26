class Solution {
    public int maxVacationDays(int[][] flight, int[][] days) {
        int[][] reverse_days = new int[days[0].length][days.length];
        int N = days.length;
        int K = days[0].length;
        int dp[][] = new int[K][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                reverse_days[j][i] = days[i][j];
            }
        }
        
        dp[0][0] = reverse_days[0][0];
        for(int i = 1; i < N; i++) 
            dp[0][i] = (flight[0][i] == 0) ? -1 : reverse_days[0][i];
        
        for(int i = 1; i < K; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = maxVacay(dp[i-1], flight, j);
                if(dp[i][j] != -1) dp[i][j] += reverse_days[i][j];
            }
        }
        int maxDays = 0;
        for(int i = 0; i < N; i++) maxDays = Math.max(maxDays, dp[K-1][i]);
        return maxDays;
    }
    
    private int maxVacay(int []dp, int[][] flight, int cityJ) {
        int max = dp[cityJ];
        for(int i = 0; i < dp.length; i++) {
            if(dp[i] > max && i != cityJ && flight[i][cityJ] != 0)
                max = dp[i];
        }
        return max;
    }
}
