package Algorithm.greedy;

import java.util.*;

/**
 * @description：
 * @date ：2021/6/13 11:32
 */
public class C14_L406 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        C14_L406.Solution s = new C14_L406().new Solution();
        System.out.println(s.reconstructQueue(people));
    }
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

            ArrayList<int[]> link = new ArrayList<>();
            for (int[] arr : people) {
                if (arr[1] < link.size()) {
                    link.add(arr[1], arr);
                } else {
                    link.add(arr);
                }
            }
            return link.toArray(new int[people.length][]);
        }
    }
}
