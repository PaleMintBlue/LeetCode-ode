class Solution {
    public int rob(int[] num) {
        int prev = 0;
        int curr = 0;
        for (int i : num) {
            int tmp = curr;
            curr = Math.max(prev + i, curr);
            prev = tmp;
        }
        return curr;
    }
}
