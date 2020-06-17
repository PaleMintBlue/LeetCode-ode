class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) nums[i] = i;
        
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if (x == y) return false;
            nums[x] = y;
        }
        
        return true;
    }
    
	// find the root
    private int find(int nums[], int i){
        while(i != nums[i]){
            nums[i] = nums[nums[i]]; 
            i = nums[i];
        }
        return i;
    }
}
