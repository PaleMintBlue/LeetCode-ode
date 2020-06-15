class Solution {
    int[] parent = new int[26];
    
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) parent[i] = i;
        
        for (String s: equations){
            char c1 = s.charAt(0);
            char c2 = s.charAt(3);
            if (s.charAt(1) == '='){
                int i1 = find(c1 - 'a');
                int i2 = find(c2 - 'a');
                if (i1 != i2) parent[i1] = i2;
            } else if (c1 == c2) return false;
        }
        
        for (String s: equations){
            if (s.charAt(1) == '!'){
                int x = find(s.charAt(0) - 'a');
                int y = find(s.charAt(3) - 'a');
                if (x == y) return false;
            }
        }
        
        return true;
    }
    
    
    private int find(int c){
        return (c == parent[c]) ? c : find(parent[c]);    
    }
}