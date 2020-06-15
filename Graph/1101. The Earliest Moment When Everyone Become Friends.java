class Solution {
    public int parent[];
    public int size[];
    
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        parent = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] l: logs) {
            union(l[1], l[2]);
            int p1 = find(l[1]);
            int p2 = find(l[2]);
            if(size[p1] == N || size[p2] == N) return l[0];
        return -1;
    }
        
    private void union (int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            if(size[x] < size[y]) {
                parent[px] = py;
                size[py] += size[px];
            }
            else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }
    
    private int find(int idx) {
        if(parent[idx] != idx) parent[idx] = find(parent[idx]);
        return parent[idx];
    }
}
