class Solution {
      public int subarraysWithKDistinct(int[] A, int K) {
        int left=0, right = 0, start = 0, len = 0;
        int[] freq = new int[A.length+1];
        int ans = 0;
        while(right <= A.length){
            if(len == K){
                while(freq[A[left]] > 1){
                    freq[A[left++]]--;
                }
                ans = ans + left-start+1;
            }
            if(len > K){
                freq[A[left++]]--;
                if(freq[A[left-1]] == 0){
                    len--;
                    start = left;
                }
            } 
            else{
                if(right == A.length) break;
                if(freq[A[right++]]++ == 0) len++;
            }
        }
        
        return ans;
    }
}
