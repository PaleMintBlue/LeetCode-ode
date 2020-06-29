class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // !: speed up if all projects are available
        boolean speedUp = true;
        for (int c: Capital) if (W < c) speedUp = false;
        if (speedUp) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int p: Profits) {
                heap.add(p);
                if (heap.size() > k) heap.poll();    
            }
            for (int h: heap) W += h; 
            return W;
        }
        
        int idx;
        int n = Profits.length;
        for(int i = 0; i < Math.min(k, n); i++) {
            idx = -1; 
            for(int j = 0; j < n; j++) { 
                if (W >= Capital[j]) {
                    if (idx == -1 ) idx = j;
                    else if (Profits[idx] < Profits[j]) idx = j;
                }
            }
            if(idx == -1) break;
            
            W += Profits[idx];
            Capital[idx] = Integer.MAX_VALUE;                
        }
        return  W;
    }
}
