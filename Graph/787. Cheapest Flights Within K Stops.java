// Bellman Ford
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
// Dijkstra
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		List<int[]>[] adjArray = prepareAdjGraph(n, flights);
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		minHeap.add(new int[] { src, 0, k + 1 });
		while (!minHeap.isEmpty()) {
			int[] edgeSrc = minHeap.poll();
			if (edgeSrc[0] == dst) return edgeSrc[1];
			if (edgeSrc[2] > 0) {
				for (int[] j : adjArray[edgeSrc[0]]) {
                    minHeap.add(new int[]{j[1], j[2] + edgeSrc[1], edgeSrc[2] - 1 });
				}
			}
		}
		return -1;
    }
    private List<int[]>[] prepareAdjGraph(int n, int[][] array) {
		List<int[]>[] adjArray = new ArrayList[n];
		for (int i = 0; i < n; i++) adjArray[i] = new ArrayList<>();
		for (int i = 0; i < array.length; i++) adjArray[array[i][0]].add(array[i]);
		return adjArray;
	}
}
