class Solution {
    /** Heap
    */
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((p1,p2)-> dist(p2) - dist(p1));
        for(int[] p : points){
            if(pq.size() == k) {
                if(dist(p) < dist(pq.peek())){
                    pq.remove();
                    pq.add(p);
                }
            } else pq.add(p);
        }
        
        int[][] result = new int[k][2];
        int count = 0;
        while(!pq.isEmpty()) result[count++] = pq.remove();
        return result;
    }
    
    private double dist(int[] p) {
        return Math.pow(p[0],2) + Math.pow(p[1],2);
    }
    
}
