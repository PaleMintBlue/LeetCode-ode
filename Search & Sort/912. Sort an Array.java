/** Stable
A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted. 
Stable: Merge, Insertion, Bubble
Unstable: Quick, Heap, Selection
*/

class Solution {

    /** Quick-Sort
    
    Worst Case: O(n^2). when the picked pivot is always an extreme (smallest or largest) element. 
    This happens when input array is sorted or reverse sorted and either first or last element is picked as pivot.
    
    Solution: random / mid -> pivot
    */
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = end;
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, pivot);
        sort(nums, start, index - 1);
        sort(nums, index + 1, end);
    }
    
    private void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
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
    
    /** Heap Sort
    */
    public static int[] sortArray(int[] nums) {
        for(int i=nums.length-1;i>=0;i--)
            bubble(nums,i,nums.length);
        for(int i=nums.length-1;i>0;i--){

            int tmp = nums[i];
            nums[i]=nums[0];
            nums[0] = tmp;
            bubble(nums,0,i);
        }
        return nums;
    }
    
    private void bubble(int[] nums, int start, int end){
        int i = start;
        int next = 2*i+1;
        while(next<end){
            if(next+1<end && nums[next+1]>nums[next])
                next++;
            if(nums[next]<=nums[start])
                break;
            nums[i]=nums[next];
            i=next;
            next = 2*i+1; //2*i+1, 2*i+2 are the children of i
        }
        nums[i]=nums[start];
    }
    
    /** Insertion
    */
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i; j > 0 && nums[j] < nums[j-1]; j--)
                swap(nums, j, j-1);  
        return nums;
    }
    
    private void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
    
    /** Selection
    */
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] < nums[min]) min = j;
            swap(nums, i, min);
        }
        return nums;
    }
  
    private void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
