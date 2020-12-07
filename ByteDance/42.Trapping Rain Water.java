class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        
        while(left < right){
            if(height[left] <  height[right]){
                if(height[left] < leftMax) res += leftMax - height[left];
                else leftMax = height[left];
                left ++;
            } else {
                if(height[right] < rightMax) res += rightMax - height[right];
                else rightMax = height[right];
                right--;
            }
        }
        
        return res;
    }
}
