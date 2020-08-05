class Solution {
    long BASE = 29L;
    long MOD = 1000000007L;
    
    public int distinctEchoSubstrings(String str) {
        HashSet<Long> set = new HashSet<>();
        int n = str.length();
        long[] hash = new long[n + 1]; // hash[i] is hash value from str[0..i]
        long[] pow = new long[n + 1]; // pow[i] = BASE^i
        pow[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * BASE + str.charAt(i - 1)) % MOD;
            pow[i] = pow[i - 1] * BASE % MOD;
        }
        
        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n; len += 2) {
                int mid = i + len / 2;
                long hash1 = getHash(i, mid, hash, pow);
                long hash2 = getHash(mid, i + len, hash, pow);
                if (hash1 == hash2) set.add(hash1);
            }
        }
        return set.size();
    }

    private long getHash(int l, int r, long[] hash, long[] pow) {
        return (hash[r] - hash[l] * pow[r - l] % MOD + MOD) % MOD;
    }
}


/** beats 96.8% 
* 103 ms
*/

class Solution {
    
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        long[] hash = new long[n + 1];
        long[] pow = new long[n + 1];
        process(text, hash, pow);
        
        Set<Integer> res = new HashSet<>();
        for (int winSize = 1; winSize <= text.length() / 2; winSize++) {
            int cnt = 0;
            for (int l = 0, r = winSize; r < text.length(); l++, r++) {
                if (text.charAt(l) == text.charAt(r)) cnt++;
                else cnt = 0;
                if (cnt == winSize) {
                    res.add(getHash(hash, pow, l + 1, r + 1));
                    cnt--;
                }
            }
        }
        return res.size();
    }
    
    private void process(String text, long[] hash, long[] pow) {
        int mod = 1_000_000_007;
        pow[0] = 1;
        for (int i = 0; i < text.length(); i++) {
            // 0 is not used to represent any character
            // a -> 1, ... z -> 26
            hash[i + 1] = (hash[i] * 27 + (text.charAt(i) - 'a' + 1)) % mod;
            pow[i + 1] = (pow[i] * 27) % mod;
        }
    }
    
    private int getHash(long[] hash, long[] pow, int l, int r) {
        int mod = 1_000_000_007;
        return (int)((hash[r] - hash[l] * pow[r - l] % mod + mod) % mod);
    }
}
