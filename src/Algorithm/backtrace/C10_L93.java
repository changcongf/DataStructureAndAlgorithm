package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：复原ip地址，注意路径删除时的选择，和剪枝。Todo：第一版代码还有优化的空间。
 * @date ：2021/6/6 15:14
 */
public class C10_L93 {
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> restoreIpAddresses(String s) {
            backtrace(new StringBuilder(), s, 0, 0);
            return res;
        }

        public void backtrace(StringBuilder path, String s, int start, int index) {
            if (index > 4) return;    // 不进行剪枝，过不了

            if (index == 4 && path.length() - 3 == s.length()) {
                res.add(path.toString());
                return;
            }
            for (int i = 1; i <= 3 && i <= s.length() - start; i++) {
                String sub = s.substring(start, start + i);
                if (!valid(sub)) {
                    continue;
                }
                if (path.length() != 0) {
                    sub = "." + sub;
                }
                path.append(sub);

                backtrace(path, s, start + i, index + 1);
                path.delete(path.length() - sub.length(), path.length());  // 值得注意
            }
        }

        public boolean valid(String s) {
            if (s.length() > 1 && s.charAt(0) == '0') return false;
            if (Integer.valueOf(s) > 255) return false;
            return true;
        }
    }
}
