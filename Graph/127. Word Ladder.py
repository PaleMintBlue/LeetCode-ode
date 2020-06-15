class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Deque<String> dq = new ArrayDeque<>();
        int res = 1;
        set.remove(beginWord);
        dq.offer(beginWord);
        while (!dq.isEmpty()) {
            int len = dq.size();
            for (int k = 0; k < len; k++) {
                String word = dq.poll();
                if (word.equals(endWord)) return res;
                char[] wordChar = word.toCharArray();
                for (int i = 0; i < wordChar.length; i++) {
                    char original = wordChar[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChar[i] = c;
                        String s = String.valueOf(wordChar);
                        if (set.contains(s)) {
                            dq.offer(s);
                            set.remove(s);
                        }
                    }
                    wordChar[i] = original;
                }
            }
            res++;
        }
        return 0;
    }
}