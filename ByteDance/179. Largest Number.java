class Solution {
    private class LargerNumberComparator implements Comparator<String> {
        
        // case: 3, 30: 330, 303
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
           return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) asStrs[i] = String.valueOf(nums[i]);
        Arrays.sort(asStrs, new LargerNumberComparator());
        if (asStrs[0].equals("0")) return "0";

        String res = "";
        for (String numAsStr : asStrs) res += numAsStr;

        return res;
    }
}
