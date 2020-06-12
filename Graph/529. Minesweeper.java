class Solution {
    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1},
                              {0, -1}, {0, 1},
                              {1, -1}, {1, 0}, {1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int r = click[0], c = click[1];
        if(board[r][c] == 'M') board[r][c] = 'X';
        else dfs(r, c, m, n, board);
        return board;
    }
    
    public void dfs(int r, int c, int m, int n, char[][] board) {
        if(board[r][c] != 'E') return;
        int numMine = check8(r, c, m, n, board);
        if(numMine > 0) {
            board[r][c] = (char)('0' + numMine);
            return;
        }
        board[r][c] = 'B';
        for (int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if(x >= 0 && x < m && y >= 0 && y < n)
                dfs(x, y, m, n, board);
        }
    }
    
    public int check8(int r, int c, int m, int n, char[][] board) {
        int numMine = 0;
        for(int[] dir: dirs) {
            int x = r + dir[0], y = c + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n) continue;
            if(board[x][y] == 'M') numMine++;
        }
        return numMine;
    }
}
