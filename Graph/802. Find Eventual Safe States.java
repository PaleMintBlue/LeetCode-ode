class Solution {
    final int WHITE = 0, GREY = 2, BLACK = 3;
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int len = graph.length;
        int[] colors = new int[len];
        for (int i = 0; i < len; i++) if(isSafe(graph, i, colors)) res.add(i);
        return res;
    }
    
    private boolean isSafe(int[][] graph, int v, int[] colors) {
        colors[v] = GREY;
        for (int u : graph[v]) {
            if (colors[u] == GREY) return false;
            if (colors[u] == WHITE && !isSafe(graph, u, colors)) return false;
        }
        colors[v] = BLACK;
        return true;
    }
}
