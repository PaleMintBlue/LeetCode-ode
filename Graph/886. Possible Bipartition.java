/** just assign a pair into 2 groups, then iteratively search the array of dislikes to:

* verify no pairs were already assigned to the same group
* propagate existing group assignments to new pairs
* only retain pairs that have no assignments yet for the next pass
* if there is a pass with no additional assignments propagated, then grab the next pair and manually assign them.
** This was just my initial attempt and potentially has O(N^2) run-time, but its simplicity makes it outperform all existing Java submissions. Also, it could very well have O(N) complexity depending on how much duplication is in the pairs and how they are ordered so the good performance may simply be a by-product of how the test cases were constructed.
*/

class Solution {
    int WHITE = 0;
    int BLUE = 1;
    int RED = 2;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int group[] = new int[N];
        boolean ungroup = true;
        int len = dislikes.length;
        
        while (len > 0) {
            int i = 0;
            if (ungroup) {
                int[] dislike = dislikes[0];
                group[dislike[0] - 1] = BLUE;
                group[dislike[1] - 1] = RED;
                i = 1;
            } else ungroup = true;
            
            int keep = 0;
            while (i < len) {
                int dislike[] = dislikes[i++];
                int p = dislike[0];
                int d = dislike[1];
                int pg = group[p - 1];
                int dg = group[d - 1];
                if (pg != WHITE) {
                    if (dg != WHITE) {
                        if (dg == pg) return false;
                    } else {
                        group[d - 1] = (RED + BLUE) - pg;
                        ungroup = false;
                    }
                } else if (dg != WHITE) {
                    group[p - 1] = (RED + BLUE) - dg;
                    ungroup = false;
                } else dislikes[keep++] = dislike;
            }
            len = keep;
        }
        return true;
    }
}
