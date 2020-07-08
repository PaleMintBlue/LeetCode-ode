class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] charArray = new int[256];
        int count = 0, res = 0, start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (charArray[s.charAt(i)]++ == 0) count++;           
            while (count > 2) {
                if (--charArray[s.charAt(start++)] == 0) count--;
            }
            res = Math.max(res, i - start + 1);
        }
        
        return res;
    }
}
