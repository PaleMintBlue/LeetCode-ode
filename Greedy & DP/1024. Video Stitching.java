class Solution {
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a,b) -> a[0] - b[0]);
        int i = 0, start = 0, end = 0;
        while (start < T) {
            while (i < clips.length && clips[i][0] <= start){
                end = Math.max(end, clips[i][1]);
                i++;
            }
            if (start == end) return -1;
            start = end;
            res++;
        }
        return res;
    }
}
