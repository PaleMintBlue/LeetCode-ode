class Solution {
    int maxLen = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) maxLen = Math.max(maxLen, str.length());
        HashSet<String> set = new HashSet(wordDict);
        HashMap<Integer, ArrayList<String>> memo = new HashMap<>();
        return DFS(s, 0, set, memo);
    }       

    // DFS function returns an array including all substrings derived from s.
    public List<String> DFS(String s, int start, Set<String> wordDict, 
                            HashMap<Integer, ArrayList<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);
        ArrayList<String> result = new ArrayList<String>();
        for (int i = start + 1; i <= s.length() && i - start <= maxLen; i++) {
            String prefix = s.substring(start, i);
            if (!wordDict.contains(prefix)) continue;
            if (i == s.length()) {
                result.add(prefix);
                break;
            }
            List<String> sublist = DFS(s, i, wordDict, memo);
            for (String sub : sublist) result.add(prefix + " " + sub);    
        }
        
        memo.put(start, result);
        return result;
    }
}
