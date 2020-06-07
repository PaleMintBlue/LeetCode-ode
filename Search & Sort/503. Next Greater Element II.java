class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        boolean[] filled = new boolean[nums.length];
        Arrays.fill(ans,-1);
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(int i=nums.length-1; i>=0; i--){            
            while(!stack.isEmpty() && nums[i] >= stack.peek()) stack.removeFirst();
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
                filled[i] = true;
            }            
            stack.addFirst(nums[i]);
        }      

        for(int i=nums.length-1;i>=0;--i){
            if(!filled[i]){
                while(!stack.isEmpty() && nums[i] >= stack.peek()) stack.removeFirst();
                if(!stack.isEmpty()){
                    ans[i] = stack.peek();
                    filled[i] = true;
                }            
            }            
        }      
        
            
        return ans;
    }
}
