class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S == null || S == "" || S.length() < K) return 0;
        
        int[] chars = new int[256];
        Arrays.fill(chars, Integer.MIN_VALUE);
        int count = 0, lo = 0, hi = 0;
        while (hi < S.length()) {
            if (chars[S.charAt(hi)] >= lo) lo = chars[S.charAt(hi)] + 1;
            chars[S.charAt(hi)] = hi;
            if (hi - lo + 1 == K) {
                count++;
                lo++;
            }
            hi++;
        }
        
        return count;
    }
}
