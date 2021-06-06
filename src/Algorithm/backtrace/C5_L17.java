package Algorithm.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：电话号码的字母组合
 * @date ：2021/6/5 23:04
 */
public class C5_L17 {


    // 自己想出来的，利用二重循环去求解问题
    class Solution {
        private Map<Character, String> map = new HashMap<>();
        private List<String> res = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            int len = digits.length();
            if (len <= 0) return res;
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            backtrace(new StringBuilder(), digits, 0);

            return res;
        }

        public void backtrace(StringBuilder ele, String digits, int start){
            if (ele.length() == digits.length()) {
                res.add(ele.toString());
                return;
            }

            for (int i = start; i < digits.length(); i++) {
                String val = map.get(digits.charAt(i));
                for (int j = 0; j < val.length(); j++) {
                    ele.append(val.charAt(j));
                    backtrace(ele, digits, i+1);
                    ele.deleteCharAt(ele.length()-1);
                }
            }
        }
    }


    // 解法二，利用index控制每个按钮的字符遍历到哪里，而不用两次循环，减少一次循环次数
    class Solution2 {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return res;

            backtrace(digits, new StringBuilder(), 0);
            return res;

        }

        public void backtrace(String digits, StringBuilder ele, int index) {
            if (index == digits.length()) {
                res.add(ele.toString());
                return;
            }

            String val = map[digits.charAt(index) - '0'];
            for (char c : val.toCharArray()) {
                ele.append(c);
                backtrace(digits, ele, index+1);
                ele.deleteCharAt(ele.length() - 1);
            }

        }
    }
}


















