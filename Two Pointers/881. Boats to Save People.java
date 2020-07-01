class Solution {
    public int numRescueBoats(int[] p, int limit) {
        Arrays.sort(p);
        int i=0;
        int j = p.length - 1;
        int res = 0;
        while(i<=j) {
            res++;
            if(p[i] + p[j] <= limit) i++;
            j--;
        }
        
        return res;
    }
}
