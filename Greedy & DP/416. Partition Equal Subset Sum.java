class Solution {
    public boolean canPartition(int[] nums) {
        int sum  = 0;
        for(int i: nums) sum += i;
        if(sum % 2 != 0) return false;
        int target = sum/2;
        boolean[] visited = new boolean[nums.length];
        return canPartitionToTwo(nums, 0, 0, visited, target);
    }
    
    public boolean canPartitionToTwo(int[] nums, int curr, int idx, boolean[] visited, int target){
        if(curr==target) return true;
        
        for(int i=idx; i<nums.length; i++){
            if(visited[i]) continue;
            int newsum = curr + nums[i];
            if(newsum <= target){
                visited[i] = true;
                if(canPartitionToTwo(nums, newsum, i+1, visited, target))
                    return true;
                visited[i] = false;
            }
            while(i<nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        
        return false;
        
    }
}
