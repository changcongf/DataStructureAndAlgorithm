package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：组合求和问题
 * @date ：2021/6/5 17:04
 */
public class C3_L216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            int sum = 0;
            backtrace(res, new ArrayList(), n, k, 1, sum);
            return res;
        }

        public void backtrace(List<List<Integer>> res, List<Integer> path , int n, int k, int start, int sum) {
            if (path.size() == k && sum == n) {
                res.add(new ArrayList(path));
                return;
            }

            for (int i = start; i <= 10 - (k - path.size()) && sum <= n; i++) {
                path.add(i);
                sum += i;
                backtrace(res, path, n, k, i + 1, sum);
                path.remove(path.size() - 1);
                sum -= i;
            }

        }
    }
}
