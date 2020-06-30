class Solution {
    // 2-pointers
    public int twoSumLessThanK(int[] A, int K) {
        int max = -1;
        Arrays.sort(A);
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] + A[hi] < K) {
                max = Math.max(S, A[lo++] + A[hi]);
            }
            else hi--;
        }
        return max;
    }
    
    // better: counting sort
    public int twoSumLessThanK(int[] A, int K) {
        int max = -1;
        int[] count = new int[1001];
        for (int i: A) count[i]++;
        int lo = 1, hi = 1000;
        while (lo <= hi) {
            if (lo + hi >= K || count[hi] == 0)
                hi--;
            else {
                if (count[lo] > (lo < hi ? 0 : 1))
                    max = Math.max(max, lo + hi);
                lo++;
            }
        }
        return max;
    }
}
