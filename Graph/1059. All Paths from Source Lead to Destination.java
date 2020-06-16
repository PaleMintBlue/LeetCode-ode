class Solution {
    final int WHITE = 0, GREY = 1, BLACK = 2, RED = 3;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        int[] colors = new int[n];
        Arrays.fill(colors, WHITE);
        List<List<Integer>> graph = new ArrayList<>();
        while(graph.size() < n) graph.add(new ArrayList<Integer>());
        for(int[] u : edges) graph.get(u[0]).add(u[1]);
        return isSafe(graph, source, destination, colors);
    }
    
    private boolean isSafe(List<List<Integer>> graph, int src, int dst, int[] colors) {
        colors[src] = GREY;
        for (int v : graph.get(src)) {
            if (colors[v] == GREY) return false;
            if (colors[v] == WHITE && !isSafe(graph, v, dst, colors)) return false;
        }
        colors[src] = BLACK;
        if(src!= dst && graph.get(src).isEmpty()) return false;
        return true;
    }
}
