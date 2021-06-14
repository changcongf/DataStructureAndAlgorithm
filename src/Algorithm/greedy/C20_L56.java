package Algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description：合并区间
 * @date ：2021/6/13 19:02
 */
public class C20_L56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();

            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            int start = intervals[0][0];
            int end = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {

                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    res.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            res.add(new int[]{start, end});
            return res.toArray(new int[res.size()][]);
        }
    }
}
