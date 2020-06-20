class Solution {
    private Map<String, Map<String, Double>> map;
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            double value = values[i];
            map.get(b).put(a, value);
            map.get(a).put(b, 1 / value);
        }
        Map<String, Double> valueMap = new HashMap<>();
        Map<String, Integer> groupMap = new HashMap<>();
        int group = 0;
        for (String v : map.keySet()) {
            if (groupMap.containsKey(v)) continue;
            dfs(v, valueMap, 1.0, groupMap, group++);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!groupMap.containsKey(a) || !groupMap.containsKey(b) || groupMap.get(a) != groupMap.get(b)) res[i] = -1.0;
            else res[i] = valueMap.get(a) / valueMap.get(b);
        }
        return res;
    }
    
    private void dfs(String v, Map<String, Double> valueMap, double value, Map<String, Integer> groupMap, int group) {
        if (groupMap.containsKey(v)) return;
        groupMap.put(v, group);
        valueMap.put(v, value);
        for (String next : map.get(v).keySet()) dfs(next, valueMap, value * map.get(v).get(next), groupMap, group);
    }
}
