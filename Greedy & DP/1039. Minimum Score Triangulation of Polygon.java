class Solution {
    public int minScoreTriangulation(int[] A) {
        int N = A.length;
        int[][] dp = new int[N][N];
        help(dp,0,N-1,A);
        return dp[0][N-1];
    }
    
    public int help(int[][] dp,int l,int h,int[] A){
        if(l >= h) return 0;
        if(dp[l][h] != 0) return dp[l][h];
        if(h - l == 2){
            int ans = A[l]*A[l+1]*A[h];
            dp[l][h] = ans;
            return ans;
        }
        dp[l][h] = Integer.MAX_VALUE;
        for(int k = l + 1 ; k <= h - 1 ; k++){
            if(k == l + 1){
                dp[l][h] = Math.min(dp[l][h],(A[h]*A[l]*A[k]) + help(dp,k,h,A));
            } else if(k == h - 1){
                dp[l][h] = Math.min(dp[l][h],(A[h]*A[l]*A[k]) + help(dp,l,k,A));
            } else {
                dp[l][h] = Math.min(dp[l][h],(help(dp,l,k,A) + A[h]*A[l]*A[k]) + help(dp,k,h,A));
            }
        }
        
        return dp[l][h];
        
    }
    
}
