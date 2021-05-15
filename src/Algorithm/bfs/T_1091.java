package Algorithm.bfs;

import java.util.LinkedList;

public class T_1091 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{0,1,1,0,0,0},{0,1,0,1,1,0},{0,1,1,0,1,0},{0,0,0,1,1,0},{1,1,1,1,1,0},{1,1,1,1,1,0}};
        System.out.println(s.shortestPathBinaryMatrix(nums));
    }
}

class Solution {
    private int[][] direction = {{0,1},{1,0},{1,1},{-1,0},{-1,1},{-1,-1},{0,-1},{1,-1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }
        if(grid[0][0]==1 || grid[grid.length-1][grid.length-1] == 1) return -1;

        LinkedList<int[]> queue = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];

        queue.offer(new int[]{0,0});
        int step = 1;
        for (int i = 0; i < grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = grid[i][j];
            }
        }
        visited[0][0] = 1;


        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0){
                int[] key = queue.poll();
                size--;
                int m = key[0];
                int n = key[1];

                for (int i = 0; i < 8; i++) {
                    int adjm = m + direction[i][0];
                    int adjn = n + direction[i][1];


                    if (!valid(grid.length, adjm, adjn)) continue;
                    // 被这里坑了好久，顺序写反了
                    if (visited[adjm][adjn] == 1) continue;


                    if (adjm == grid.length-1 && adjn == grid[0].length-1) return ++step;
                    queue.add(new int[]{adjm, adjn});
                    visited[adjm][adjn] = 1;
                }
            }
            step++;
        }

        return -1;
    }
    public boolean valid(int length, int m, int n) {
        if (m < 0 || n < 0 || m >= length || n >= length ) return false;
        return true;
    }
}

