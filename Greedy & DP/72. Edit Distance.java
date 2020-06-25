class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] dp = new int[n+1];
        for(int i = 1; i<=n ;i++) dp[i] = i;
        
        for(int  i = 1; i<=m; i++){
            dp[0] = i;
            int prev = i-1;
            for(int j = 1; j<=n; j++){    
                int tmp = dp[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[j] = prev;
                else dp[j] = Math.min( Math.min(prev, dp[j-1]), dp[j]) + 1;
                prev = tmp;                
            }
        }
        
        return dp[n];
        
        
    }
}
