class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {   
        List<List<String>> res = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList); 
        if (!dict.contains(endWord)) return res;

        Map<String, List<String>> map = new HashMap<>();

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        bfs(startSet, endSet, dict, map, false);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(map, beginWord, endWord, list, res);

        return res;
    }

    private void bfs(Set<String> startSet, Set<String> endSet, Set<String> dict, Map<String, List<String>> map, boolean reversed) {
        if (startSet.size() == 0) return; 
        if (startSet.size() > endSet.size()) {
            bfs(endSet, startSet, dict, map, !reversed);
            return;
        }

        Set<String> nextSet = new HashSet<>(); 
        dict.removeAll(startSet); 
        boolean finished = false;

        for (String word : startSet) {
            char[] letters = word.toCharArray();
            for (int i = 0; i < letters.length; i++) {
                char old = letters[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    letters[i] = c;
                    String next = String.valueOf(letters);
                    if (dict.contains(next)) {
                        if (endSet.contains(next)) finished = true;
                        else nextSet.add(next); 
                        String key = reversed ? next : word;
                        String value = reversed ? word : next;
                        if (map.get(key) == null) map.put(key, new ArrayList<>());
                        map.get(key).add(value);
                    }
                }
                letters[i] = old;
            }
        }
        if (!finished) bfs(nextSet, endSet, dict, map, reversed);
    }

    private void dfs(Map<String, List<String>> map, String beginWord, String endWord, List<String> list, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (String next : map.getOrDefault(beginWord, new ArrayList<>())) {
            list.add(next);
            dfs(map, next, endWord, list, result);
            list.remove(list.size() - 1);
        }
    }
}
