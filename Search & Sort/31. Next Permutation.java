class Solution {
   /** One Pass
   */
   public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] num, int p1, int p2) {
        int tmp = num[p1];
        num[p1] = num[p2];
        num[p2] = tmp;
    }
}

   /** Binary search
   */
    public void nextPermutation(int[] num) {
        if (num.length < 2) return;
        int tail = num.length - 1;
        while (tail > 0 && num[tail - 1] >= num[tail]) tail--;
        if (tail == 0) {
            reverse(num, 0, num.length - 1);
            return;
        } else {
            int k = tail - 1;
            int nextLarger = nextLarger(num, tail, num.length-1,k);
            swap(num, k, nextLarger);
            reverse(num, tail, num.length - 1);
            return;
        }
    }
    
    private void reverse(int[] num, int p1, int p2) {
        for (int i = p1; i <= (p1 + p2) / 2; i++) swap(num, i, p1 + p2 - i);
    }

    private void swap(int[] num, int p1, int p2) {
        int tmp = num[p1];
        num[p1] = num[p2];
        num[p2] = tmp;
    }

    private int nextLarger(int[] num, int left, int right, int k) {
        k = num[k];
        if (left == right) return left;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] == k) {
                while (num[mid] == k) mid--;
                return mid;
            } else if (num[mid] > k) {
                if (num[mid + 1] <= k) return mid;
                else left = mid + 1;
            } else right = mid - 1;
        }
        return left;
    }
}
