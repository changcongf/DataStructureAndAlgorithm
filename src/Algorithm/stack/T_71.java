package Algorithm.stack;

import java.util.*;

public class T_71 {
}

class Solution71 {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String s : path.split("/")) {
            if(set.contains(s) && s.equals("..") && !s.isEmpty()) {
                stack.pop();
            }
            if(!set.contains(s)) {
                stack.push(s);
            }
        }

        String res = "";
        while(!stack.isEmpty()) {
            res = '/' + res;
        }
        res = '/' + res;
        return res;
    }
}
