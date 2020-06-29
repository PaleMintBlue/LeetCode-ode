class Solution {
    
    class Worker {
        public int quality;
        public int wage;
        public double ratio;
        
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = wage / (double)quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[wage.length];
        for (int i = 0; i < wage.length; i++) 
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers, (w1, w2) -> w1.ratio > w2.ratio ? 1 : -1);
        double res = Double.MAX_VALUE;
        int totalQuality = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (Worker worker : workers) {
            maxHeap.add(worker.quality);
            totalQuality += worker.quality;
            if (maxHeap.size() == K) {
                res = Math.min(res, totalQuality * worker.ratio);
                totalQuality -= maxHeap.poll();
            }
        }
        return res;
    }
    
}
