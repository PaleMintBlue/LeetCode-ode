class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, n = gas.length, start = 0, gasLeft = 0;
        while(i < start+n){
            if(gasLeft < 0){
                start = i%n;    
                gasLeft = 0;    
            }
            gasLeft += gas[i%n] - cost[i++ %n]; 
        }
        return gasLeft>=0  && i==start+n ? start : -1 ;
    }
}
