class Solution {
	public int threeSumMulti(int[] A, int target) {
		long[] c = new long[101];
		long res = 0;
		for (int a : A) c[a]++;
		for (int i = 0; i <= target/3; i++) {
			for (int j = i; j <= 100; j++) {
				int k = target - i - j;
				if (k > 100 || k < 0 || k < j) continue;
				if (i == j && j == k) res += c[i] * (c[i]-1) * (c[i]-2) / 6;
				else if (i != j && j == k) res += c[i] * c[j] * (c[j]-1) / 2;
				else if (i == j && j != k) res += c[i] * (c[i]-1) / 2 * c[k];
				else res += c[i] * c[k] * c[j];
			}
		}
		return (int)(res % (1e9 + 7));
	}
}
