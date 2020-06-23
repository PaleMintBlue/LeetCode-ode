class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        return cost(days, costs, 0, new int[days.length]);
    }

    public static int cost(int[] days, int[] costs, int day, int[] memo) {
        if (day == days.length) return 0;
        if (memo[day] != 0) return memo[day];

        int day1pass = cost(days, costs, day + 1, memo) + costs[0];

        int next7 = next_day(days, 7, day);
        int day7pass = cost(days, costs, next7, memo) + costs[1];

        int next30 = next_day(days, 30, day);
        int day30pass = cost(days, costs, next30, memo) + costs[2];

        int ans = Math.min(day1pass, Math.min(day7pass, day30pass));
        memo[day] = ans;

        return ans;
    }

    public static int next_day(int[] days, int val, int purchase) {
        int validity = days[purchase] + val - 1;
        for (int i = purchase; i < days.length; i++) {
            if (days[i] > validity) return i;
        }
        return days.length;
    }
}
