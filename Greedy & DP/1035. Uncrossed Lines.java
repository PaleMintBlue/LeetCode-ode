class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int aLen = A.length, bLen = B.length;
        int[][] maxCounts = new int[aLen+1][bLen+1];
        for (int i = 1; i <= aLen; ++i) {
            for (int j = 1; j <= bLen; ++j) {
                maxCounts[i][j] = A[i-1] == B[j-1] ? maxCounts[i-1][j-1] + 1 : Math.max(maxCounts[i-1][j], maxCounts[i][j-1]);
            }
        }
        return maxCounts[aLen][bLen];
    }
}
