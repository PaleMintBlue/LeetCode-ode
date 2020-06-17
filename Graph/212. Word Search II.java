class Solution {
    private Trie root;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> collected = new ArrayList<>();
        if (board.length < 1 || board[0].length < 1) return collected;
        
        root = new Trie();
        for (String word : words) Trie.addWord(root, word);
        
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++) 
                dfs(board, i, j, root, collected);
        return collected;
    }
    
    
    private void dfs(char[][] board, int i, int j, Trie cur, List<String> collected) {
        char c = board[i][j];
        if (c == '-') return;
        cur = cur.getChild(c);
        if (cur == null) return;
        if (cur.end != null) {
            String s = cur.end;
            collected.add(s);
            cur.end = null;
            if (cur.len() == 0) Trie.deleteWord(root, s);
        }
        board[i][j] = '-';
        if (i > 0) dfs(board, i - 1, j, cur, collected);
        if (i + 1 < board.length) dfs(board, i + 1, j, cur, collected);
        if (j > 0) dfs(board, i, j - 1, cur, collected);
        if (j + 1 < board[0].length) dfs(board, i, j + 1, cur, collected);
        board[i][j] = c;
    }
}

class Trie {
    private Trie[] children;
    public String end;
    private int length = 0;
    
    private Trie addChild(char c) {
        int i = c - 'a';
        if (children == null) children = new Trie[26];
        if (children[i] == null) {
            children[i] = new Trie();
            length++;
        }
        return children[i];
    }
    
    public Trie getChild(char c) { return (children == null) ? null : children[c - 'a'];}
    
    public int len() { return length; }
    
    public static void addWord(Trie root, String word) {
        Trie t = root;
        for (char c : word.toCharArray()) t = t.addChild(c);
        t.end = word;
    }
    
    public static void deleteWord(Trie root, String word) {
        Trie toDelOn = root;
        char toDel = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (root.length > 1) {
                toDelOn = root;
                toDel = c;
            }
            root = root.getChild(c);
            // if (root == null) throw new IllegalArgumentException();
        }
        toDelOn.children[toDel - 'a'] = null;
        toDelOn.length--;
        // if (root.length != 0) throw new IllegalArgumentException();
    }
}
