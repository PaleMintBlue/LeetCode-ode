class Solution {
    int[] parents;
    
    private void union(int x, int y){ parents[find(x)] = find(y);}
    
    private int find(int x){
        if(x!=parents[x]) parents[x] = find(parents[x]);
        return parents[x];
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length + 1;
        parents = new int[N];
        for(int i=0; i<N; i++) parents[i] = i;
        
        int[] edge1 = new int[2], edge2 = new int[2];
        int[] parent = new int[N];
        for(int i=0; i<N-1; i++){ 
            int nodeU = edges[i][0];
            int nodeV = edges[i][1];
            if(parent[nodeV] > 0){  
                edge1 = new int[]{parent[nodeV], nodeV};
                edge2 = new int[]{nodeU, nodeV};
                edges[i][0] = -1;
                edges[i][1] = -1;
            }
            parent[nodeV] = nodeU; 
        }
        for(int i=0; i<N-1; i++){
            int nodeU = edges[i][0];
            int nodeV = edges[i][1];
            if(nodeU<0 || nodeV<0) continue;
            int rootU = find(nodeU);
            int rootV = find(nodeV);
            if(rootU==rootV) return edge1[0]==0? new int[]{nodeU, nodeV} : edge1;
            union(nodeU, nodeV);
        }
        return edge2;
    }
}
