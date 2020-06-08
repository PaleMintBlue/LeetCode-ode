class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0) return 0;

        int left = 0, right = 0;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }

        while(left < right){
            int mid = (left + right)/2;
            int count = 1;
            int sum = 0;
            for(int w : weights){
                if(sum + w > mid){
                    count++;
                    sum = 0;
                }
                sum += w;
            }

            if(count > D) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
