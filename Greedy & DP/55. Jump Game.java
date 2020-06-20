
class Solution {
    public boolean canJump(int[] nums) {
        return Jump(nums, nums.length - 1);
    }
    public boolean Jump(int[] nums, int index){
        if(index == 0) return true;
        for(int i = index - 1; i >= 0; i--){
            if(nums[i] >= index - i) return Jump(nums, i);
        }
        return false;
    }
}
