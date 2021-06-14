package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description：最少数量的箭引爆气球
 * @date ：2021/6/13 14:51
 */
public class C17_L452 {
    public static void main(String[] args) {
        C17_L452.Solution1 s = new C17_L452().new Solution1();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int[][] points1 = {{0,1},{1,2}};
        System.out.println(s.findMinArrowShots(points));
    }

    // 对右端进行排序
    class Solution1 {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);

            int x = points[0][1];
            int cnt = 1;
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > x) {
                    cnt++;
                    x=points[i][1];
                }
            }
            return cnt;
        }
    }


    // 对左端进行排序
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> a[0] <= b[0] ? -1 : 1); // 排序不能用减号，防止int数据溢出

            int x = points[0][1];
            int sum = 1;
            for (int i = 1; i < points.length; i++) {
                if(points[i][0] > x) {
                    sum++;
                    x = points[i][1];
                } else {
                    x = Math.min(points[i][1], x);
                }
            }
            return sum;
        }
    }
}
