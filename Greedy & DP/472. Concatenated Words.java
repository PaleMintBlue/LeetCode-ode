public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : words) set.add(word);
        for (String word : words) if (isConcatenated(set, word)) res.add(word);
        return res;
    }
    
    private boolean isConcatenated(Set<String> set, String s) {
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                String left = s.substring(i);
                if (set.contains(left) || isConcatenated(set, left))
                    return true;
            }
        }
        return false;
    }
}

/** Follow-up
* consider word.length when substring
**/
