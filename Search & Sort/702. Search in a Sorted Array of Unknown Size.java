/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
  public int search(ArrayReader reader, int target) {
    if (reader.get(0) == target) return 0;
    if (reader.get(0) > 10000) return -1;
    int left = 0, right = target - reader.get(0);
      
    int mid, num;
    while (left <= right) {
      mid = (left + right)/2;
      num = reader.get(mid);
      if (num == target) return mid;
      if (num < target) left = mid + 1;
      else right = mid - 1;
    }
      
    return -1;
  }
}
