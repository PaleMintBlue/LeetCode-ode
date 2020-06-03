/** 2-dfs
    */
class Solution {

    int[] res, count;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    private void dfs(int node, int prev) {
        for (int i : tree.get(node)) {
            if (i == prev) continue;
            dfs(i, node);
            count[node] += count[i];
            res[node] += res[i] + count[i];
        }
        count[node]++;
    }


    public void dfs2(int node, int prev) {
        for (int i : tree.get(node)) {
            if (i == prev) continue;
            res[i] = res[node] - count[i] + count.length - count[i];
            dfs2(i, node);
        }
    }
    
}

/** 14ms solution, graph + 2-dfs
    */
class Solution {
   
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Graph g = new Graph(N);
        int[] distance = new int[N];
        int[] count = new int[N];
        
        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
            g.addEdge(edges[i][1], edges[i][0]);
        }
        
        g.insertDistanceAndCount(0, distance, count, new boolean[N]);
        g.updateDistanceAndCount(0, distance, count, new boolean[N]);
        return distance;

    }
}

class Graph {
    int V;
    List<Integer>[] adjList;
    
    Graph(int V) {
        this.V = V;
        adjList = new List[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    void addEdge(int src, int des) {
        adjList[src].add(des);
    }
    
    void insertDistanceAndCount(int root, int[] d, int[] c, boolean[] v) {
        v[root] = true;
        c[root] = 1;
        for (int node : adjList[root]) {
            if (!v[node]) {
                insertDistanceAndCount(node, d , c, v);
                d[root] += d[node] + c[node];
                c[root] += c[node];
            }
        }
    }
    
    void updateDistanceAndCount(int root, int[] d, int[] c, boolean[] v) {
        v[root] = true;
        for (int node : adjList[root]) {
            if (!v[node]) {
                d[node] = d[root] - c[node] + (V - c[node]);
                updateDistanceAndCount(node, d, c, v);
            }
        }
    }
    
    int[] distanceSums() {
        int[] sums = new int[V];
        for (int i = 0; i < V; i++) {
            sums[i] = distanceSum(i, new boolean[V], 0);
        }
        return sums;
    }
    
    int distanceSum(int root, boolean[] visited, int sum) {
        int currSum = 0;
        visited[root] = true;
        for (int node : adjList[root]) {
            if (!visited[node]) {
                currSum += distanceSum(node, visited, sum + 1);   
            }
        }
        return sum + currSum;
    }
}
