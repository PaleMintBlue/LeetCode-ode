class Solution {
    public int climbStairs(int n) {
        int oneStep=1, twoStep=0;
        for(int i=n-1;i>=0;i--){
            int totalWays = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = totalWays;
        }
    return oneStep;
    }
}
