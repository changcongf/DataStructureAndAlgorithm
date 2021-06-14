package Algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @date ：2021/6/14 10:12
 */
public class C22_L738 {
    public static void main(String[] args) {
        C22_L738.Solution1 s = new C22_L738().new Solution1();
        System.out.println(s.monotoneIncreasingDigits(10));
    }

    class Solution1 {
        public int monotoneIncreasingDigits(int n) {
            int res = 0;
            int ones = 111111111;
            for (int i = 0; i < 9; i++) {
                while ( res + ones > n) {
                    ones /= 10;
                }
                res += ones;
            }
            return res;

        }
    }

    class Solution {
        public int monotoneIncreasingDigits(int n) {
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                list.add(n % 10);
                n /= 10;
            }
            int mark = -1;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > list.get(i - 1)) {
                    mark = i;
                    list.set(i, list.get(i) - 1);
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (i < mark) {
                    list.set(i, 9);
                }
            }

            int sum = 0;
            for (int i = list.size() - 1; i >= 0; i--) {
                sum = sum * 10 + list.get(i);
            }
            return sum;
        }
    }
}
