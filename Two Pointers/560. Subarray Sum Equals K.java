class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i]; 
            int remain = sum - k;
            if(map.containsKey(remain)) count += map.get(remain);
            map.put(sum, map.getOrDefault(sum, 0) + 1); 
            if(sum == k) count++;
        }
        return count;
    }
}
