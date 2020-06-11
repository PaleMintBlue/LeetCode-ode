class Solution {
      /** DFS
      * T: O(N x N), S: O(M x N)
      */
      private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
      }

      public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;
        int cnt = 0;
        for (int r = 0; r < nr; r++) {
          for (int c = 0; c < nc; c++) {
            if (grid[r][c] == '1') {
              ++cnt;
              dfs(grid, r, c);
            }
          }
        }

        return cnt;
  }
  
  /** BFS
  */
  public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;

    int nr = grid.length;
    int nc = grid[0].length;
    int cnt = 0;

    for (int r = 0; r < nr; r++) {
      for (int c = 0; c < nc; c++) {
        if (grid[r][c] == '1') {
          ++cnt;
          grid[r][c] = '0'; 
          Deque<Integer> dq = new ArrayDeque<>();
          dq.addFirst(r * nc + c);
          while (!dq.isEmpty()) {
            int id = dq.removeFirst();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row-1][col] == '1') {
              dq.addFirst((row-1) * nc + col);
              grid[row-1][col] = '0';
            }
            if (row + 1 < nr && grid[row+1][col] == '1') {
              dq.addFirst((row+1) * nc + col);
              grid[row+1][col] = '0';
            }
            if (col - 1 >= 0 && grid[row][col-1] == '1') {
              dq.addFirst(row * nc + col-1);
              grid[row][col-1] = '0';
            }
            if (col + 1 < nc && grid[row][col+1] == '1') {
              dq.addFirst (row * nc + col+1);
              grid[row][col+1] = '0';
            }
          }
        }
      }
    }

    return cnt;
  }
}
}
