package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description： 经典组合问题，leetcode一遍就AC
 * @date ：2021/6/5 15:23
 */
public class C2_L77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backtrace(res, new ArrayList<Integer>(), k, 1, n);
            return res;
        }

        public void backtrace(List<List<Integer>> res, ArrayList<Integer> ele, int k, int start, int n) {
            if (ele.size() == k) {
                res.add(new ArrayList(ele));
                return;
            }

            for (int i = start; i <= n - (k - ele.size()) + 1; i++) {  // 减枝处理优化
                ele.add(i);
                backtrace(res, ele, k, i+1, n);
                ele.remove(ele.size() - 1);
            }
        }




    }
}
