class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>()); 
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Deque<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) leaves.offer(i);
        }
        
        while (n > 2) {
            int num_leaves = leaves.size();
            n -= num_leaves;
            for(int i = 0; i < num_leaves; i++) {
                int u = leaves.poll();
                int v = adj.get(u).iterator().next();
                adj.get(v).remove(new Integer(u)); // remove by finding value.
                if (adj.get(v).size() == 1) leaves.add(v);
            }
        }
        return (List)leaves;
    }

}
