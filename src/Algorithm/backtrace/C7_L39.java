package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：组合总和
 * @date ：2021/6/6 10:20
 */
public class C7_L39 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backtrace(candidates, target, 0, new ArrayList<Integer>(), 0);
            return res;
        }

        public void backtrace(int[] candidates, int target, int sum, ArrayList<Integer> path, int start) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                res.add(new ArrayList(path));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                sum += candidates[i];
                backtrace(candidates, target, sum, path, i);
                path.remove(path.size()-1);
                sum -= candidates[i];
            }
        }
    }
}
