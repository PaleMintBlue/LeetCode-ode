class Solution { 
    public int longestRepeatingSubstring(String s) {
        Set<String> visited = new HashSet<>();
        int max = 0, i = 0;
        
        while(i <  s.length()) {
            int j = i + max + 1;
            if (j > s.length()) return max;
            String x = s.substring(i, j);
            
            if (visited.contains(x)) {
                max++;
                visited.clear();
                i = 0;
                continue;
            } else {
                visited.add(x);
                i++;
            }            
        }
        
        return max;
    }
}
