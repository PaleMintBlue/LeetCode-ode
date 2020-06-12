class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> res = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    res.add(sb.toString());
                }
            }
        }
        return res.size();
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length 
           || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u"); // up
        dfs(grid, i+1, j, sb, "d"); // down
        dfs(grid, i, j-1, sb, "l"); // left
        dfs(grid, i, j+1, sb, "r"); // right
        sb.append("b"); // back
    }
}
