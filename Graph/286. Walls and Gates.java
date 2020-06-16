class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return;
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    
    public void dfs(int[][] rooms, int x, int y, int steps) {
        if(!isValid(rooms, x, y) || rooms[x][y] < steps) return;
        rooms[x][y] = steps;
        dfs(rooms, x, y + 1, steps + 1);
        dfs(rooms, x + 1, y, steps + 1);
        dfs(rooms, x, y - 1, steps + 1);
        dfs(rooms, x - 1, y, steps + 1);
    }
    
    private boolean isValid(int[][] rooms, int x, int y) {
        return x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length;
    }
}
