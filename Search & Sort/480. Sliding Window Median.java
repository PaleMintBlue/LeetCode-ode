class Solution {
   public double[] medianSlidingWindow(int[] nums, int k) {
       double[] result = new double[nums.length - k + 1];
       int j=0;
       
       PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
       PriorityQueue<Integer> right = new PriorityQueue<>();
       
       for (int i = 0; i < nums.length; i++) {
            left.add(nums[i]);
            right.add(left.poll());
            if(right.size()>left.size()) left.add(right.poll());
            if (left.size() + right.size() == k) {
                if (left.size()==right.size())
                    result[j] = (double)((long)left.peek() + (long)right.peek())/2;
                else result[j] = (double) left.peek();
                if (!left.remove(nums[j])) right.remove(nums[j]);
                
                j++;
            }
        }
        return result;
    }
    
    /** TreeSet
    */
}
