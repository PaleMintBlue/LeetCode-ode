class Solution {
    int total = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
		Arrays.sort(coins);
		count(amount, coins.length-1, coins, 0);
		return total == Integer.MAX_VALUE ? -1:total;
    }
    
	private void count(int amount, int index, int[] coins, int count){
		if (index<0 || count>=total-1) return;
		int c = amount/coins[index];
	    for (int i = c;i>=0;i--){
			int curr = count + i;
			int next = amount - i*coins[index];
			if (next>0 && curr<total) count(next, index-1, coins, curr);
			else if (curr<total) total = curr;
			else if (curr>=total-1) break;
		}
	}

}
