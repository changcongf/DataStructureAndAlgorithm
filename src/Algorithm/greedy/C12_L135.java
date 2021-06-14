package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description：分发糖果
 * @date ：2021/6/13 11:05
 */
public class C12_L135 {
    // 优化，用一个数组
    class Solution1 {
        public int candy(int[] ratings) {
            int[] res = new int[ratings.length];
            Arrays.fill(res, 1);

            // 先满足左规则
            for (int i = 1; i < res.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    res[i] = res[i - 1] + 1;
                }
            }

            // 再满足右规则
            int sum = 0;
            for (int i = res.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    res[i] = Math.max(res[i], res[i + 1] + 1);
                }
                sum += res[i];
            }

            sum += res[res.length - 1];
            return sum;
        }
    }

    class Solution {
        public int candy(int[] ratings) {
            int[] res = new int[ratings.length];
            Arrays.fill(res, 1);

            // 先满足左规则
            for (int i = 1; i < res.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    res[i] = res[i - 1] + 1;
                }
            }

            // 再满足右规则
            int[] res1 = new int[ratings.length];
            Arrays.fill(res1, 1);
            for (int i = res.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    res1[i] = res1[i + 1] + 1;
                }
            }

            int sum = 0;
            for (int i = 0; i < ratings.length; i++) {
                sum += Math.max(res[i], res1[i]);
            }
            return sum;
        }
    }
}