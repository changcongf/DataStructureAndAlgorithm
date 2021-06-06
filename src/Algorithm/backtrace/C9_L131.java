package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @date ：2021/6/6 14:03
 */
public class C9_L131 {
    class Solution {
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> partition(String s) {
            backtrace(s, 0, new ArrayList<String>());
            return res;
        }

        public void backtrace(String s, int start, ArrayList<String> path) {
            if (start == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 1; i <= s.length() - start; i++) {
                String subStr = s.substring(start, start+i);
                if (!valid(subStr)) {
                    continue;
                }
                path.add(subStr);
                backtrace(s, start+i, path);
                path.remove(path.size()-1);
            }
        }

        public boolean valid(String s) {
            if (s.length() == 0) return false;

            int begin = 0;
            int end = s.length() - 1;
            while (begin < end) {
                if (s.charAt(begin) != s.charAt(end)) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
        }
    }
}
