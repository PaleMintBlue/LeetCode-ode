class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) {
			return intervals.length;
		}

		int[] startTimesArray = new int[intervals.length];
		int[] endTimesArray = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			startTimesArray[i] = intervals[i][0];
			endTimesArray[i] = intervals[i][1];
		}

		Arrays.sort(startTimesArray);
		Arrays.sort(endTimesArray);

		int startTime = 0, endTime = 0;
		int rooms = 0;

		while (startTime < intervals.length) {
			if (startTimesArray[startTime] >= endTimesArray[endTime]) {
				startTime++;
				endTime++;
			} else {
				startTime++;
				rooms++;
			}
		}
		return rooms;
    }
}
