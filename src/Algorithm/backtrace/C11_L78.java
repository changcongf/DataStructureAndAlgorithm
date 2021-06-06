package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：经典子集问题
 * @date ：2021/6/6 22:02
 */
public class C11_L78 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            backtrace(nums, 0, new ArrayList<Integer>());
            return res;
        }

        public void backtrace(int[] nums, int start, ArrayList<Integer> path) {
            res.add(new ArrayList<>(path));
            if (start >= nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                path.add(nums[i]);
                backtrace(nums, i+1, path);
                path.remove(path.size()-1);
            }
        }

    }

}
