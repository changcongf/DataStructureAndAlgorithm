package Algorithm.greedy;

/**
 * @description：判断是否为子序列
 * @date ：2021/6/14 21:12
 */
public class Cy8_L392 {
    class Solution {
        public boolean isSubsequence(String s, String t) {

            int k = 0;
            for (int i = 0; i < t.length() && k < s.length() ; i++) {
                if (s.charAt(k) == t.charAt(i)) k++;
            }
            return k == s.length();
        }
    }
}
