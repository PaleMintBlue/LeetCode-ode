class Solution {

    /** Quick-Sort
    */
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = quickSort(arr, left, right);
            sort(arr, left, pivot-1);
            sort(arr, pivot, right);  
        }
    }
    
    public int quickSort(int[] arr, int left, int right) {
        int pivot = left + (right - left) / 2;
        int pivotVal = arr[pivot];
        while (left <= right) {
            while (arr[left] < pivotVal) left++;
            if (left <= right) { 
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                right--;
            }
            while (arr[right] > pivotVal) right--;
            if (left <= right) { 
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
            }
        }
        return left;
    }
    
    
    /** MergeSort
    */
   public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
    private void sort(int[] arr, int left, int right){
        if(right - left + 1 < 2) return;
        int mid = left + (right - left) / 2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }
    private void merge(int[] arr, int left, int mid, int right){
        int low = left, high = mid+1;
        int[] res = new int[right-left+1];
        for(int i = 0; i < res.length; i++){
            if(high > right ||  (arr[low] < arr[high] && low < mid+1)) {
                res[i] = arr[low++];
            } else {res[i] = arr[high++];}
        }
        for(int i = 0; i < res.length; i++) arr[i+left] = res[i];
        
    }
}
}
