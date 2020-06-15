class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] parent = new int[26];
        for(int i = 0; i < 26; ++i) parent[i] = i;
        union(A, B, parent);
        return lexi(S, parent);
    }

    private int find(int[] parent, int i) {
        while(i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(String a, String b, int[] parent) {
        int len = a.length();
        for(int i = 0; i < len; ++i) {
            int p1 = find(parent, a.charAt(i) - 'a');
            int p2 = find(parent, b.charAt(i) - 'a');
            int min = Math.min(p1, p2);
            parent[p1] = min;
            parent[p2] = min;
        }
    }

    private String lexi(String S, int[] parent) {
        StringBuilder sb = new StringBuilder();
        for(char ch : S.toCharArray()) {
            int tmp = ch - 'a';
            int p = find(parent, tmp);
            sb.append((char)(p + 'a'));
        }

        return sb.toString();    
    }
}
