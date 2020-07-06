class Solution {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int res = 1;
        int anchor = 0;
        
        for(int i=1;i<N;i++) {
            int c = Integer.compare(A[i-1],A[i]); // x<y:-1, x=y:0, x>y:1
            if(c == 0) anchor = i;
            else if(i == N-1 || c * Integer.compare(A[i],A[i+1]) != -1) {
                res = Math.max(res,i-anchor+1);
                anchor = i;
            }
        }
        
        return res;
    }
}
