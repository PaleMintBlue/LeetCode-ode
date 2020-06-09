class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = nums[0];
        int hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        while (low <= high) {
            int mid = lo + (hi-lo) / 2; // can't be (lo+hi)/2 for long
            int count = groupNeed(nums, mid);
            if (count > m) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    
    private int groupNeed(int[] nums, int val) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (num + sum > val) {
                sum = 0;
                count++;
            }
            sum += num;
        }
        return count;
    }
}
