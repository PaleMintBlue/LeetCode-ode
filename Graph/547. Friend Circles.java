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
}
     
   
}
