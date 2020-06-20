class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        
        dp[0]=nums[0];
        for(int i=1;i<N;i++)
            dp[i] = Math.max(nums[i]+dp[i-1],nums[i]);   

        int max=dp[0];
        for(int i=1;i<nN;i++)
            max=Math.max(dp[i],max);

        return max;

    }
}
