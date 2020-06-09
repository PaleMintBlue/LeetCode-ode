class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = biSearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
    
    /** Arrays.binarySearch()
    * https://blog.csdn.net/cxhply/article/details/49423501
    * better for large input
    */
    private int biSearch(int[] arr, int lo, int hi, int k) {
        if (arr.length == 0) return -1;
        hi = hi - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1; 
            if (arr[mid] < k) lo = mid + 1;
            else if (arr[mid] > k) hi = mid - 1;
            else return mid;
        }
        return ~lo;
    }
}
