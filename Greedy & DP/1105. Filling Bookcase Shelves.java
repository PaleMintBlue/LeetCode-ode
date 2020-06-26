class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int dp[] = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= books.length; i++) {
            int sum = books[i-1][0];
            int max = books[i-1][1];
            dp[i] = dp[i-1] + books[i-1][1];
            for(int j = i-1; j>=1; j--) {
                if(sum + books[j-1][0]<=shelf_width) {
                    max = Math.max(books[j-1][1], max);
                    dp[i] = Math.min(dp[j-1] + max, dp[i]);
                    sum = sum + books[j-1][0];
                } else {
                    break;
                }
            }
        }
        return dp[books.length];
    }
}
