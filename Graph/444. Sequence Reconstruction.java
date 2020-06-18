class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        Map<Integer, Integer> order = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        
        for (int i=0; i<n; i++) idx.put(org[i], i);
        
        for (List<Integer> seq : seqs) {
            Integer prev = null;
            for (int i : seq) {
                if (i > n || i < 1) return false;
                if (order.containsKey(i)) {
                    if (prev != null) 
                        order.put(i, Math.max(order.get(i), idx.get(prev)));
                }
                else {
                    if (prev == null) order.put(i, -1);
                    else order.put(i, idx.get(prev));
                }
                prev = i;
            }
        }
        if (order.size() != n) return false;
        for (int i: org) if (order.get(i) != idx.get(i)-1) return false;
        return true;
    }
}
