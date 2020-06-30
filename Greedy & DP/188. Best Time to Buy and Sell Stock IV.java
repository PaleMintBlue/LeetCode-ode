
//https://www.cnblogs.com/grandyang/p/4295761.html
class Solution {
    private int naive(int[] prices) {
        int profit =0;
        for(int i=1; i<prices.length; i++) 
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        return profit;
    }
    
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        if(k>=N/2) return naive(prices);
        int[][]  dp = new int[N + 1][2];
        int row = 0;
        for(int j =1; j<=k; j++) {
            int global=0, local=0;
            for(int i=N-1; i>=0; i--){
                local = Math.max(local, prices[i] + dp[i+1][1 - row]);
                global = Math.max(global, local - prices[i]);
                dp[i][row] = global;
            }
            row = 1-row;
        }
        return dp[0][1-row];
        
    }
}
