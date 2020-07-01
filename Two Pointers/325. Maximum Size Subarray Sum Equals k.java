class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) res = i + 1;
            else if(map.containsKey(sum - k)){
                res = Math.max(res, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
