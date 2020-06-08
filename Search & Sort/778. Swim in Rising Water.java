class Solution {
    int[] dir = {-1, 0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int left = grid[0][0];
        int right = grid.length * grid.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[][] isVisited = new boolean[N][N];
            boolean reach = connect(grid, mid, 0, 0, isVisited);
            if (!reach) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private boolean connect(int[][] grid, int level, int x, int y, boolean[][] isVisited) {
        int N = grid.length;
        isVisited[x][y] = true;
        if (x == N - 1 && y == N - 1) return true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i];
            int nextY = y + dir[i + 1];
            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N
                    || isVisited[nextX][nextY] || grid[nextX][nextY] > level) continue;
            if (connect(grid, level, nextX, nextY, isVisited)) return true;
        }
        return false;
    }
}
