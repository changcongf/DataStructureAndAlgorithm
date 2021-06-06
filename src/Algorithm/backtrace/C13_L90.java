package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description：子集问题II，有重复元素先排序，然后注意去重条件
 * @date ：2021/6/6 22:59
 */
public class C13_L90 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backtrace(nums, 0, new ArrayList<Integer>());
            return res;

        }

        public void backtrace(int[] nums, int start, ArrayList<Integer> path) {
            res.add(new ArrayList<Integer>(path));
            if (start >= nums.length) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                backtrace(nums, i + 1, path);
                path.remove(path.size() - 1);
            }

        }
    }
}
