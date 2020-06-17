class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int r = maze.length;
        int c = maze[0].length;
        int[][] minDistance = new int[r][c];
        
        for (int i = 0; i < r; i++)
            Arrays.fill(minDistance[i], Integer.MAX_VALUE);

        minDistance[start[0]][start[1]] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.offer(new int[] { start[0], start[1], 0 });
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if (minDistance[x][y] < dist) continue;
            if (x == dest[0] && y == dest[1]) return dist;

            for (int[] dir : directions) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                int steps = 0;
                while (nx >= 0 && nx < r && ny >= 0 && ny < c && maze[nx][ny] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    steps++;
                }
                nx -= dir[0];
                ny -= dir[1];

                if (minDistance[nx][ny] > dist + steps) {
                    minDistance[nx][ny] = dist + steps;
                    minHeap.offer(new int[] { nx, ny, minDistance[nx][ny] });
                } 
            }
        }
        return -1;
    }
}
