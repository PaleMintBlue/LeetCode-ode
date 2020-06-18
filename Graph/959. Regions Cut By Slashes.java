class Solution {
    
    public int regionsBySlashes(String[] grid) {
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int r = grid.length + 1;
        int c = grid[0].length() + 1;
        int len = r * c;
        int[] parent = new int[len];
        int[] rank = new int[len];
        
        for (int i = 0; i < len; i++) parent[i] = i;

        for (int i = 0; i < c; i++) union(parent, rank, 0, i); // 1st row
        for (int i = len - 1; i >= len - c; i--) union(parent, rank, 0, i); // last row
        for (int i = 0; i < r; i++) union(parent, rank, 0, i * c); // 1st col
        for (int i = 0; i < c; i++) union(parent, rank, 0, i * c + c - 1); // last col
        for (int i = 0; i < len; i++) find(parent, i); // path compression

        int regions = 1;
        for (int i = 0; i < r-1; i++) {
            for (int j = 0; j < c-1; j++) {
                if ((grid[i].charAt(j) == '/' 
                    && !union(parent, rank, i * c + j + 1, (i + 1) * c + j)) || 
                    (grid[i].charAt(j) == '\\' 
                    && !union(parent, rank, i * c + j, (i + 1) * c + j + 1)))
                        regions++;
            }
        }
   	return regions;
   }
    
    private int find(int[] parent, int v) {
        if (parent[v] == v) return v;
        int group = find(parent, parent[v]);
        parent[v] = group;
        return group;
       }

    private boolean union(int[] parent, int[] rank, int v1, int v2) {
        int p1 = find(parent, v1);
        int p2 = find(parent, v2);
        if (p1 != p2) {
            if (rank[p1] > rank[p2]) parent[p2] = p1;
            else {
                parent[p1] = p2;
                if (rank[p1] == rank[p2]) rank[p2]++;
            }
            return true;
        }
        return false;
       }
}
