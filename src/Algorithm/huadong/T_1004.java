package Algorithm.huadong;

public class T_1004 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,0,0,1,1,1,0,0,1};
        System.out.println(s.longestOnes(nums,2));

    }



    static class Solution {
        // 窗口不减
        public int longestOnes(int[] nums, int k) {
            if (nums.length == 0) return 0;

            int left = 0;
            int right = 0;
            while(right < nums.length) {

                if (nums[right++] == 0) {
                    k--;
                }

                if (k < 0 && nums[left++] == 0) {
                    k++;
                }
            }
            return right -left;

        }


    }
}


