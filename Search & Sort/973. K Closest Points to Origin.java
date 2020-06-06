class Solution {
    /** Heap
    */
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((p1,p2)-> dist(p2) - dist(p1));
        for(int[] p : points){
            if(pq.size() == k) {
                if(dist(p) < dist(pq.peek())){
                    pq.remove();
                    pq.add(p);
                }
            } else pq.add(p);
        }
        
        int[][] result = new int[k][2];
        int count = 0;
        while(!pq.isEmpty()) result[count++] = pq.remove();
        return result;
    }
    
    private double dist(int[] p) {
        return Math.pow(p[0],2) + Math.pow(p[1],2);
    }
    
    /** Quick Sort
    */
    public int[][] kClosest(int[][] points, int k) {
        quickSort(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0, k);
        
    }
    
    private int[][] quickSort(int[][] nums, int left, int right, int k) {
        int mid = (left + right)/2;
        swap(nums, mid, left);
        int pivot = dist(nums[left]);
        int index=left;
        for (int i = left+1; i<=right; i++) {
            if (dist(nums[i]) < pivot) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, left, index);
        
        if (index == k-1) return nums;
        else  if (index > k-1) return quickSort(nums, left, index - 1, k);
        else return quickSort(nums, index + 1, right, k);
    }
    
    private void swap(int[][] arr, int p1, int p2) {
        int[] tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
    
    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
    
}
