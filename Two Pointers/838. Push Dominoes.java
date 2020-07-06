class Solution {
    public String pushDominoes(String dominoes) {
        char[] res = ("L" + dominoes + "R").toCharArray();
        int left = 0, right = 0, i = 1;
        while(i < res.length) {
            if(res[i] != '.') {
                right = i;
                if(!(res[left] == 'L' && res[right] == 'R')) {
                    int start = left, end = right;
                    while(start < end) {
                        res[start++] = res[left];
                        res[end--] = res[right];
                    }
                        if(res[left] == res[right] && start == end) {
                            res[start] = res[left];    
                        }
                }
                left = i;
            }
            ++i;
            
        }
        
        return new String(res).substring(1, res.length - 1);    
    }
}
