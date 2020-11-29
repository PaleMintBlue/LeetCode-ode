class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        boolean[] visited = new boolean[s.length() + 1];
        dp[0] = true;
        visited[0]  = true;

        return memo(s, wordDict, s.length(), dp, visited);
    }

    private boolean memo(String s, List<String> wordDict, int i , boolean[] dp, boolean[] visited){
        if (visited[i]) return dp[i];

        String cur = s.substring(0, i);
        for (String word : wordDict){
            if (cur.endsWith(word)) {
                if (memo(s, wordDict, i-word.length(), dp, visited)){
                    dp[i] = true;
                    visited[i] =true;
                    return true;
                }
            }
        }
        dp[i] = false;
        visited[i] = true;

        return false;
    }
}
