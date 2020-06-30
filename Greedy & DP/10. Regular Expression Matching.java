class Solution{
    public boolean isMatch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        if (n == 0) return m == 0;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n; i+=2) {
            if (pattern.charAt(i) != '*') break;
            else dp[0][i + 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char a = text.charAt(i);
                char b = pattern.charAt(j);
                if (b == '.' || a == b) dp[i + 1][j + 1] = dp[i][j];
                else if (b == '*') dp[i + 1][j + 1] = dp[i + 1][j - 1]  
                    || ((text.charAt(i) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') && dp[i][j + 1]); 
            }
        }

        return dp[m][n];
    }
    
    
    // dp + memo
    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(), p.toCharArray(), 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }
    
    private boolean match(char[] s, char[] p, int sInd, int pInd, Boolean[][] memo) {
        if (pInd == p.length) return sInd == s.length;
        if (memo[sInd][pInd] != null) return memo[sInd][pInd]; // already visited
        boolean currMatch = sInd < s.length && (s[sInd] == p[pInd] || p[pInd] == '.');
        
        if (pInd < p.length - 1 && p[pInd + 1] == '*') { // next char is *
            memo[sInd][pInd] = match(s, p, sInd, pInd + 2, memo) || // 0 matches - move p 2 steps forward (to skip *)
                   (currMatch && match(s, p, sInd + 1, pInd, memo)); // 1 or more matches - move only s forward
        }
        else { // next char is NOT *
            memo[sInd][pInd] = currMatch && match(s, p, sInd + 1, pInd + 1, memo); // move s and p forward
        }
        return memo[sInd][pInd];
    }
}
