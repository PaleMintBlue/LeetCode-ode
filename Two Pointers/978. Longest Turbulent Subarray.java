class Solution {
    public int maxTurbulenceSize(int[] A) {
        int up = 1;
        int maxCount = 0;
        int curr = 0;
        int N = A.length;
        if(N < 2) return N;
        for(int i=0; i < N-1; i++){
            int k = Integer.compare(A[i], A[i+1]) * up;
            if (k == 0) curr = 0;
            else {
                if(k == 1) {
                    curr++; 
                    up *= -1;
                } else curr = 1;
            }
            maxCount = Math.max(curr+1, maxCount);
        }
        return maxCount;
    }
}

class Solution {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }
}
