// class Solution {
//     public int[] prisonAfterNDays(int[] cells, int N) {
//         if(N==0) return cells;
//         N = N % 14;
//         if(N == 0) N = 14;
//         int[] res = new int[8];
//         for(int i=1;i<7;i++){
//             if(cells[i-1] == cells[i+1]) res[i] = 1;
//             else res[i] = 0;
//         }
//         N--;
//         return prisonAfterNDays(res, N);
//     }
    
// }

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        boolean isFastForwarded = false;

        // cells to bitmap
        int stateBitmap = 0x0;
        for (int cell : cells) {
            stateBitmap <<= 1;
            stateBitmap = (stateBitmap | cell);
        }

        while (N > 0) {
            if (!isFastForwarded) {
                if (seen.containsKey(stateBitmap)) {
                    N %= seen.get(stateBitmap) - N;
                    isFastForwarded = true;
                } else
                    seen.put(stateBitmap, N);
            }
            if (N > 0) {
                N -= 1;
                stateBitmap = this.nextDay(stateBitmap);
            }
        }

        // bitmap back to the cells
        int ret[] = new int[cells.length];
        for (int i = cells.length - 1; i >= 0; i--) {
            ret[i] = (stateBitmap & 0x1);
            stateBitmap  >>= 1;
        }
        return ret;
    }

    protected int nextDay(int stateBitmap) {
        stateBitmap = ~(stateBitmap << 1) ^ (stateBitmap >> 1);
        stateBitmap = stateBitmap & 0x7e;
        return stateBitmap;
    }
}
