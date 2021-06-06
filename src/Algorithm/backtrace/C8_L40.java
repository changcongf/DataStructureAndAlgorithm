package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description：组合问题II，注意去重的方式，排序+与前一个比较
 * @date ：2021/6/6 11:37
 */
public class C8_L40 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backtrace(candidates, target, 0, 0, new ArrayList<Integer>());
            return res;

        }

        public void backtrace(int[] candidates, int target, int start, int sum, ArrayList<Integer> path) {
            if(sum > target) return;

            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;

                path.add(candidates[i]);
                sum += candidates[i];
                backtrace(candidates, target, i+1, sum, path);
                path.remove(path.size()-1);
                sum -= candidates[i];
            }
        }
    }
}
