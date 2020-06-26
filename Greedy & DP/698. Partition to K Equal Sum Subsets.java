class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum % k != 0) return false;
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        return dfs(nums, k, nums.length - 1, 0, sum / k, isVisited);
    }

    private boolean dfs(int[] nums, int k, int index, int sum, int target, boolean[] isVisited) {
        if (k == 0) return true;
        if (sum == target) 
            return dfs(nums, k - 1, nums.length - 1, 0, target, isVisited);
        for (int i = index; i >= 0; i--) {
            if (isVisited[i] || nums[i] + sum > target) continue;
            isVisited[i] = true;
            if (dfs(nums, k, i - 1, sum + nums[i], target, isVisited)) return true;
            isVisited[i] = false;
        }
        return false;
    }
}
