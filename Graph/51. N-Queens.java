class Solution {
    List<List<String>> ans=new ArrayList<>();
    boolean[][] visited;
    
    public List<List<String>> solveNQueens(int n) {
        visited = new boolean[3][2*n-1];
        char[][] board = new char[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                board[i][j]='.';
            }
        }
        dfs(0,board);
        return ans;
    }
    
    private void dfs(int row,char[][] board){
        if(row==board.length){
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<board.length;++i){
                tmp.add(String.valueOf(board[i]));
            }
            ans.add(tmp);
        }else{
            for(int col=0;col<board.length;++col){
                if(!visited[0][col]&&!visited[1][row+col]&&!visited[2][row-col+board.length-1]){
                    board[row][col]='Q';
                    visited[0][col]=visited[1][row+col]=visited[2][row-col+board.length-1]=true;
                    dfs(row+1,board);
                    board[row][col]='.';
                    visited[0][col]=visited[1][row+col]=visited[2][row-col+board.length-1]=false;
                }
            }
        }

    }

}
