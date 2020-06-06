class Solution {
    /** Heap Sort
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int stone: stones) pq.offer(stone);
        while (pq.size()>1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 != s2) pq.offer(s1-s2);
        }
        return pq.size()==0 ? 0 : pq.poll();
    }
    
    /** Bucket Sort
    */
    public int lastStoneWeight(int[] stones) {
        int stoneWeight = 0, stoneArrayLength = stones.length;

        while (stoneArrayLength > 1) {
            Arrays.sort(stones, 0, stoneArrayLength); 

            int lastElemIndex = stoneArrayLength - 1;
            stones[lastElemIndex - 1] = stones[lastElemIndex] - stones[lastElemIndex - 1];
            stoneArrayLength--; // Reduce the array range to sort for every iteration
        }

        if (stones.length >= 1) {
            stoneWeight = stones[0];
        }

        return stoneWeight;
    }
}
