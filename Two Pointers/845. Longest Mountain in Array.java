class Solution {
    public int longestMountain(int[] A) {
        int N = A.length;
        int res = 0, start = 0;
        while (start < N) {
            int end = start;
            if (end + 1 < N && A[end] < A[end + 1]) {
                while (end + 1 < N && A[end] < A[end + 1]) end++;
                if (end + 1 < N && A[end] > A[end + 1]) {
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    res = Math.max(res, end - start + 1);
                }
            }
            start = Math.max(end, start + 1);
        }

        return res;
    }
}

