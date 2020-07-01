class Solution {
    public int shortestWay(String source, String target) {
        int i = 0, res = 0;
        while (i < target.length()) {
            int j = source.indexOf(target.charAt(i));
            if (j == -1) return -1;
            i ++;
            while (j < source.length() && i < target.length()) {
                if (j == -1) break;
                j = source.indexOf(target.charAt(i), j+1);
                if (j != -1) i++;
            }
            res++;
        }
        return res;
    }
}
