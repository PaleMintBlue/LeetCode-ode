class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        int prev=-1;
        for(int i=nums.length-1;i>=0;i--){
            if(dp[i]==max && (prev==-1||prev%nums[i]==0)){
                res.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }
        return res;
    }
}
