class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        
       for(int i=0; i < intervals.length-1; i++) {
            int [] a = intervals[i];
            int [] b = intervals[i+1];
            if(b[0] < a[1]) {
                count++;
                b[0] = Math.max(a[0], a[1]);
                b[1] = Math.min(a[1], b[1]); 

            }
                 
        }
       
        
        return count;
    }
}
