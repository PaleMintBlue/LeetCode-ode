class Solution {
    public int shortestSubarray(int[] A, int K) {
        int head = 0, tail = 0;
        int result = Integer.MAX_VALUE;
        int[] values = new int[A.length], indexes = new int[A.length];
        int sum = 0, minus = 0;
        
        for (int i = 0; i < A.length; ++i) {
            sum = Math.max(0, sum + A[i]);
            
            if (sum == 0) {
                tail = head;
                minus = 0;
            } else if (A[i] <= 0) minus += A[i];
              else {
                if (minus < 0) {
                    while (tail > head && minus <= 0) minus += values[--tail];
                    values[tail++] = minus;
                    minus = 0;
                }
                
                values[tail] = A[i];
                indexes[tail++] = i;
                
                while (head < tail && sum - values[head] >= K ) sum -= values[head++];
                if (sum >= K) result = Math.min(result, i - indexes[head] + 1);
            }
        }
            
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
