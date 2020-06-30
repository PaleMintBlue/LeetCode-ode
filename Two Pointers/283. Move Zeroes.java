class Solution {
    public void moveZeroes(int[] nums) {
        for (int idx = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) swap(nums, idx++, cur);
        }
    }
    
    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
