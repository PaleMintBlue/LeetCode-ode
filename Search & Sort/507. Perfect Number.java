class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;
        int sum = 0;
        for (int i=1; i * i <= num; i++) {
            sum += (num % i == 0) ? (i * i == num) ? i : i + num/i : 0;
        }
         return (sum - num == num);
    }
}
