class Solution {

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low <= high) {
            int mid = ( low + high ) / 2;
            if (!count(mid, m, n, k)) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    
    private boolean count(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) count += Math.min(x / i, n);
        return count >= k;
    }
}
