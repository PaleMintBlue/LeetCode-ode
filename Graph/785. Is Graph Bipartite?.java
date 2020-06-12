class Solution {
    int[] groups,adjList[];
    boolean visited[];
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        groups = new int[N];
        visited = new boolean[N];
        adjList = graph;
        for(int i=0;i<N;i++) if(!visited[i] && !dfs(i,1)) return false;
        return true;
    }
    
    private boolean dfs(int i,int group)
    {
        if(groups[i] != 0) return groups[i]==group ? true : false;
        groups[i]=group; 
        visited[i]=true;
        for(int j:adjList[i]) if(!dfs(j,-group)) return false;
        return true;
    }
}
