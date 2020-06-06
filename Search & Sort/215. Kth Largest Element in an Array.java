class Solution {
     /** Quick Select
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, nums.length+1-k);
    }
    
    private int quickSort(int[] nums, int left, int right, int k) {
        int mid = (left + right)/2;
        swap(nums, mid, left);
        int pivot = nums[left];
        int index=left;
        for (int i = left+1; i<=right; i++) {
            if (nums[i] < pivot) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, left, index);
        
        if (index == k-1) return pivot;
        else  if (index > k-1) return quickSort(nums, left, index - 1, k);
        else return quickSort(nums, index + 1, right, k);
    }
    
    private void swap(int[] arr, int p1, int p2) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
    
     /** Heap
     */
     public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) {
            if(pq.size() == k) {
                if(n > pq.peek()) {
                    pq.remove();
                    pq.add(n);
                }
            }
            else pq.add(n);
        }
        
        return pq.remove();
    }
}
