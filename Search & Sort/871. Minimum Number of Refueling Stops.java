class Solution {
//     public int minRefuelStops(int target, int startFuel, int[][] stations) {
//         int len = stations.length;
//         long[] dp = new long[len + 1];
//         dp[0] = startFuel;
        
//         for (int i = 0; i < len; i++)
//             for (int j = i; j >= 0; j--)
//                 if (dp[j] >= stations[i][0])
//                     dp[j+1] = Math.max(dp[j+1], dp[j] + (long) stations[i][1]);

//         for (int i = 0; i <= len; ++i) if (dp[i] >= target) return i;
//         return -1;
//     }
    
    /
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long dist = startFuel;
        int res = 0, idx = 0;
        while (true) {
            while (idx < stations.length && stations[idx][0] <= dist) {
                pq.offer(-stations[idx][1]);
                idx++;
            }
            
            if (dist >= target) return res;
            if (pq.isEmpty()) return -1;
            dist += -pq.poll();
            res++;
        }
        
    }
}
