package Algorithm.greedy;

/**
 * @description：加油站
 * @date ：2021/6/10 22:58
 */
public class C11_L134 {
    // 贪心解法
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int curSum = 0;
            int rest = 0;
            int res = 0;

            for (int i = 0; i < gas.length; i++) {
                rest = gas[i] - cost[i];
                curSum += rest;
                if (curSum < 0) {
                    res = i + 1;
                    curSum = 0;
                }
            }
            return res;
        }
    }


    // 暴力破解法
    class Solution1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int remain;

            for (int i = 0; i < gas.length; i++) {
                remain = 0;
                remain = gas[i] - cost[i];
                int start = i + 1;
                for (; start < i + gas.length && remain >= 0; start++) {
                    int index = start >= gas.length ? start - gas.length : start;
                    remain += gas[index] - cost[index];
                }
                if (start == gas.length + i && remain >= 0) return i;
            }
            return -1;
        }
    }

}