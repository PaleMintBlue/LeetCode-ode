class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        double[] minCost = new double[n];
        Arrays.fill(minCost, Double.POSITIVE_INFINITY);
        minCost[src] = 0;

        for (int i = 0; i < K + 1; i++) {
            double[] curr = Arrays.copyOf(minCost, n); 
            for (int[] f : flights) {
                int from = f[0];
                int to = f[1];
                int cost = f[2];
                curr[to] = Math.min(curr[to], minCost[from] + cost);
            }
            minCost = curr;
        }
        return minCost[dst] == Double.POSITIVE_INFINITY ? -1 : (int) minCost[dst];
    }
}
