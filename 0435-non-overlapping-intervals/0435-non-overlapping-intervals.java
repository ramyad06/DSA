class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int prev = Integer.MIN_VALUE;
        int cnt = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= prev) {
                prev = intervals[i][1];
                cnt++;
            }
        }
        return n-cnt;
    }
}