class Solution {

    int[][] direction = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        pq.offer(new int[]{A[0][0], 0, 0});
        int res = A[0][0];
        visited[0][0] = true;
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            res = Math.min(res, top[0]);
            if(top[1] == m - 1 && top[2] == n - 1) {
                break;
            }
            
            for(int[] dir : direction) {
                int x = dir[0] + top[1];
                int y = dir[1] + top[2];
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                pq.offer(new int[]{A[x][y], x, y});
                visited[x][y] = true;
            }
        }
        return res;
    }
}
