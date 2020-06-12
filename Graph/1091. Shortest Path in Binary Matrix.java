class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0]==1 || grid[N-1][N-1] == 1) return -1;
        
        int[][] dirs={{1,0},{1,-1},{1,1},{0,1},{0,-1},{-1,0},{-1,1},{-1,-1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 1});
        grid[0][0]=2;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            if(cur[0] == N*N-1) return cur[1];
            for(int i=0; i<8; i++) {
                int nc = cur[0] / N + dirs[i][0];
                int nr = cur[0] % N + dirs[i][1];
                if(nc<0 || nc>=N || nr<0 || nr>=N || grid[nc][nr]!=0) continue;
                dq.offer(new int[]{nc*N + nr, cur[1] + 1});
                grid[nc][nr]=2;
            }
        }
        return -1;
    }
}
