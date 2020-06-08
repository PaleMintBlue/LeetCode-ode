class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = (int) Math.pow(10,9);
        while (left < right) {
            int mid = (left + right) / 2;
            if (!possible(piles, H, mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p: piles) time += (p-1) / K + 1;
        return time <= H;
    }
}
