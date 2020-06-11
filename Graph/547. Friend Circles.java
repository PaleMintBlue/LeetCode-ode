class Solution {
     /** DFS
     * T: log(n^2), S: log(n)
     */
     public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
     
     /** BFS
     * T: log(n^2), S: log(n)
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dq.addFirst(i);
                while (!dq.isEmpty()) {
                    int n = dq.removeFirst();
                    visited[n] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[n][j] == 1 && visited[j] == 0)
                            dq.addFirst(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
     
     
    /** Union-Find
    * ref: https://blog.csdn.net/guoziqing506/article/details/78752557
    * T: O(log(n^3)), S: O(n)
    */
    class UF {
        private int[] parent, size;
        private int count;
        
        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

        }
        
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            
            // compress path
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        
        public int count() { return count; }
    }
    
    
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (M[i][j] == 1)
                    uf.union(i, j);
        return uf.count();
    }
     
   
}
