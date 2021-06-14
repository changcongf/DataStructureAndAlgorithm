package Algorithm.greedy;

/**
 * @description：修改一个数成为非递减数组
 * @date ：2021/6/14 21:48
 */
public class Cy9_L665 {
    class Solution {
        public boolean checkPossibility(int[] nums) {

            boolean changed = false;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] <= nums[i+1]) continue;

                if (changed) return false;

                if (i == nums.length - 2 || nums[i] <= nums[i+2]) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }
                changed = true;
            }
            return true;
        }
    }
}
