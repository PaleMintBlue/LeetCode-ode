class Solution {
    // DFS
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotten(grid, i, j, 2);
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotten(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0  || (1 < grid[i][j] && grid[i][j] < minutes)) return;
        else {
            grid[i][j] = minutes;
            rotten(grid, i - 1, j, minutes + 1);
            rotten(grid, i + 1, j, minutes + 1);
            rotten(grid, i, j - 1, minutes + 1);
            rotten(grid, i, j + 1, minutes + 1);
        }
    }
    
    
    //BFS
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return -1;
        
        int[][] dirs = { {1,0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2) dq.offer(new int[]{i, j});
                else if(grid[i][j]==1) fresh++;
            }
        }
       
        if(fresh==0) return 0;
        int level = -1;
        
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i=0; i<size; i++){
                int[] c = dq.poll();
                for(int[] d: dirs){
                    int x = c[0]+d[0];
                    int y = c[1]+d[1];
                    if(x>=0 && y>=0 && x<m && y<n){
                        if(grid[x][y]==1){
                            grid[x][y] = 2;     
                            dq.offer(new int[]{x, y}); 
                            fresh--;
                        }   
                    }
                }
            }
            level++;
        }
        return (fresh==0) ? level : -1;
    }

}
