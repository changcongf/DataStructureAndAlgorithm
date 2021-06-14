package Algorithm.greedy;

/**
 * @description：买股票的最佳时机，含手续费
 * @date ：2021/6/14 14:48
 */
public class C23_L714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int profit = 0;
            int buy = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < buy - fee) {
                    buy = prices[i] + fee;
                } else if (prices[i] > buy) {
                    profit += prices[i] - buy;
                    buy = prices[i];
                }
            }
            return profit;
        }
    }
}
