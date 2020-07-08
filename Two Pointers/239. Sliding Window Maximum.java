class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    int N = nums.length;
    if (N * k == 0) return new int[0];
    if (k == 1) return nums;

    int [] left = new int[N], right = new int[N]
    left[0] = nums[0];
    right[N - 1] = nums[n - 1];
    for (int i = 1; i < N; i++) {
      if (i % k == 0) left[i] = nums[i];  
      else left[i] = Math.max(left[i - 1], nums[i]);
      int j = N - i - 1;
      if ((j + 1) % k == 0) right[j] = nums[j];  
      else right[j] = Math.max(right[j + 1], nums[j]);
    }

    int [] output = new int[N - k + 1];
    for (int i = 0; i < N - k + 1; i++)
      output[i] = Math.max(left[i + k - 1], right[i]);

    return output;
  }
}
