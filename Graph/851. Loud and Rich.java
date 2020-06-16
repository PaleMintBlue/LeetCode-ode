class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        
        int[] rCounts = new int[N];
        for (int[] r : richer) rCounts[r[1]]++;
        
        int[][] rLists = new int[N][];
        for (int i=0;i<N;i++) rLists[i] = new int[rCounts[i]];
        
        for (int[] r : richer) rLists[r[1]][--rCounts[r[1]]] = r[0];
        
        int[] result = new int[N];
        Arrays.fill(result, -1);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == -1) loudAndRich(rLists, quiet, result, i);
        }
        
        return result;
    }
    
    private int loudAndRich(int[][] rLists, int[] quiet, int[] result, int i) {
        if (result[i] != -1) return result[i];
        result[i] = i;
        
        for (int richer : rLists[i]) {
            int r = loudAndRich(rLists, quiet, result, richer);
            if (quiet[r] < quiet[result[i]]) result[i] = r;
        }
        
        return result[i];
    }
}
