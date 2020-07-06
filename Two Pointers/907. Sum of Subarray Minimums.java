class Solution {
    public int sumSubarrayMins(int[] A) {
        int N = A.length;
        int[] left = new int[N];
        int[] right = new int[N];
        
        for (int i = 0; i < N; i++) {
            int countLeft = 1;
            int j = i - 1;
            while (j >= 0 && A[j] > A[i]) { 
                countLeft += left[j];
                j -= left[j];
            }
            left[i] = countLeft;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int countRight = 1;
            int j = i + 1;
            while (j < N && A[j] >= A[i]) { 
                countRight += right[j];
                j += right[j];
            }
            right[i] = countRight;
        }
        
        long result = 0;
        for (int i = 0; i < N; i++) result += (A[i] * left[i] * right[i]);

        return (int) (result % (1e9 + 7));
    }
}
