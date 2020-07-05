class Solution {
    public int longestWPI(int[] hours) {
        int res = 0, diff = 0; 
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < hours.length; i++) {
            diff += hours[i] > 8 ? 1 : -1;
            if (diff > 0) res = i + 1;
            else {
                map.putIfAbsent(diff, i);  
                res = Math.max(res, i - map.getOrDefault(diff - 1, Integer.MAX_VALUE));
            }
        }
        return res;
    }
}
