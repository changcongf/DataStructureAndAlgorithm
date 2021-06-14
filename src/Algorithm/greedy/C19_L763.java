package Algorithm.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：划分字母
 * @date ：2021/6/13 18:49
 */
public class C19_L763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] position = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                position[index] = i;
            }

            int len = 0;
            int post = 0;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                len++;
                int index = s.charAt(i) - 'a';
                if (position[index] > post) post = position[index];
                if (post == i) {
                    res.add(len);
                    len = 0;
                }
            }
            return res;
        }
    }
}
