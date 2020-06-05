/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid - 1))
                left = mid;
            else
                right = mid - 1;
        }
        
        int idx = biSearch(mountainArr, 0, left, target,false);
        if (idx == -1) idx = biSearch(mountainArr, left+1, mountainArr.length() - 1, target,true);
        return idx;
        
    }
    
    private int biSearch(MountainArray mountainArr, int left, int right, int target, boolean reverse) { 
        while (left <= right) {
            int mid = (left + right) / 2;
            int curr = mountainArr.get(mid);
            if (curr==target) return mid;
            if(reverse){
                if (curr < target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (curr < target) left = mid + 1;
                else right = mid - 1;
            }
            
        }
        return -1;
    }
    
}
