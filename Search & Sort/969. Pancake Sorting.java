
  class Solution {
    List<Integer> res;
    public List<Integer> pancakeSort(int[] A) {
        this.res = new ArrayList<>();
        sort(A, A.length - 1);
        return res;
    }
    
    public void sort(int[] A, int lastIndex) {
        if (lastIndex == 0) return;
        int max = A[0];
        int maxIndex = 0;
        for (int i = 0; i<=lastIndex; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        
        res.add(maxIndex+1);
        flip(A, 0, maxIndex);
        res.add(lastIndex+1);
        flip(A, 0, lastIndex);
        sort(A, lastIndex-1);
    }
      
      private void flip(int[] arr, int left, int right){
        while (left < right) {
            int tmp = arr[right];
            arr[right] = arr[left];
            arr[left] = tmp;
            left++;
            right--;
        }
      }
          
       
}
