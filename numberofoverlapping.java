class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       // If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Sort the intervals by their end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int end = intervals[0][1]; // End time of the last selected interval
        int count = 0; // Number of intervals to remove

        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) { // There is an overlap
                count++; // Increment the removal count
            } else {
                end = intervals[i][1]; // No overlap, update the end time
            }
        }

        return count;
    }
}
