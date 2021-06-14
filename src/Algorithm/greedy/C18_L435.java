package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description：
 * @date ：2021/6/13 16:37
 */
public class C18_L435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[1] == b[1]) return 0;
                else if (a[1] < b[1]) return -1;
                else return 1;
            });

            int right = intervals[0][1];
            int cnt = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < right) {
                    cnt++;
                } else {
                    right = intervals[i][1];
                }
            }
            return cnt;
        }
    }
}
