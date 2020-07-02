class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, left=0, res = 0 ;  
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<k) {
                product *= nums[i];
                while(product>=k && left<=i) {
                    product /= nums[left];
                    left++;
                }
                res += (i-left+1);
            } else {
                left = i+1;
                product = 1;
            }
        }
        return res;
    }
}
