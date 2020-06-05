class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        Arrays.sort(nums);
        int mid = nums[n/2];
        int i = (n - 1) / 2 * 2, j = i, k = 1;
        for (int c = 0; c < n; ++c) {
            if (nums[j] < mid) {
                swap(nums, i, j);
                i -= 2; j -= 2;
                if (j < 0) j = n / 2 * 2 - 1;
            } else if (nums[j] > mid) {
                swap(nums, j, k);
                k += 2;
            } else {
                j -= 2;
                if (j < 0) j = n / 2 * 2 - 1;
            }
        }
    }
 
    private void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
