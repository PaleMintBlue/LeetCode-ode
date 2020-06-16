class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
            return Collections.emptyList();

        int r = matrix.length;
        int c = matrix[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, c - 1, Integer.MIN_VALUE);
        }
        
        for (int j = 0; j < c; j++) { 
            dfs(matrix, pacific, 0, j, Integer.MIN_VALUE);
            dfs(matrix, atlantic, r - 1, j, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int r, int c, int height) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c] || matrix[r][c] < height) return;
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        visited[r][c] = true;
        for (int[] dir : directions) 
            dfs(matrix, visited, dir[0] + r, dir[1] + c, matrix[r][c]);
    }
}
