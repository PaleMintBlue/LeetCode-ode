class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<prerequisites.length; i++)
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] done = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i] && !dfs(graph,visited,done,ans,i))
                return new int[]{};
        }
        int[] res = new int[numCourses];
        int i=0;
        for(int x: ans) res[i++]=x;
        return res;
    }
    
    private boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, boolean[] done, ArrayList<Integer> ans, int idx){
        if(done[idx]) return true;
        if(visited[idx]) return false;
        visited[idx] = true;
        
        for(int i:graph[idx]){
            if(!dfs(graph,visited,done,ans,i)) return false;
            if(!visited[i]) ans.add(i);  
        }
        done[idx]=true;
        ans.add(idx);
        return true;
    }
}
