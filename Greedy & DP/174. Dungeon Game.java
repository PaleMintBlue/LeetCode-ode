// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int[][] dp = new int[dungeon.length][dungeon[0].length];
        
//         for (int i = dungeon.length-1; i >= 0;i--)
//             for (int j = dungeon[0].length-1; j >= 0;j--) {
//                 if (i == dungeon.length-1 && j == dungeon[0].length-1) {
//                     dp[i][j] = Math.max(1, 1-dungeon[i][j]);
//                 } else if (i == dungeon.length-1) {
//                    dp[i][j] = Math.max(1, 0-(dungeon[i][j] - dp[i][j+1]));
//                } else if (j == dungeon[0].length-1) {
//                     dp[i][j] = Math.max(1, 0-(dungeon[i][j] - dp[i+1][j]));
//                 } else {
//                     dp[i][j] = Math.max(1, Math.min(0-(dungeon[i][j] - dp[i][j+1]),
//                                                     0-(dungeon[i][j] - dp[i+1][j])));
//                 }
//             }
//         return Math.max(dp[0][0], 1);
//     }
// }

class Solution {
    Integer[][]  powers;
    public int calculateMinimumHP(int[][] dungeon) {
        if(null==dungeon || dungeon.length==0) return -1;
        int r=dungeon.length;
        int c=dungeon[0].length;
        powers = new Integer[r+1][c+1];
        if(r==1 && c==1){
           return  dungeon[0][0] < 0 ? -dungeon[0][0] +1 : 1; 
        }
        return dfs(dungeon, 0, 0, r, c);
    }
    
    private int dfs(int[][] dungeon, int i, int j, int rows, int columns){
        if(i==rows-1 && j==columns-1 ) return dungeon[i][j]>0 ? 1 : -dungeon[i][j]+1 ;
        if(powers[i][j] != null) return powers[i][j];
        
        if(i>=0 && j>=0 && i<rows && j<columns){
            int tmp = Math.min(dfs(dungeon, i, j+1, rows, columns), dfs(dungeon, i+1, j, rows, columns)) - dungeon[i][j];
            int tmpMax  = Math.max(tmp , 1);
            powers[i][j] = tmpMax;
            return tmpMax;
        }
        
        return Integer.MAX_VALUE;
    }
}
