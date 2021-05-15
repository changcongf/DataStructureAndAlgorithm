package Algorithm.Matrix;

public class MatrixFindKth {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;

            if (row == 0 || col == 0) {
                return 0;
            }

            int left = matrix[0][0];
            int right = matrix[row - 1][col - 1];
            int cnt;

            while (left < right) {
                int mid = left + (right - left) / 2;
                cnt = countMatrix(matrix, mid);
                if (cnt == k) {
                    return mid;
                } else if (mid < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public int countMatrix(int[][] matrix, int target) {
            int row = matrix.length - 1;
            int col = 0;
            int cnt = 0;

            while(row >= 0 && col < matrix[0].length) {
                if (matrix[row][col] < target) {
                    col++;
                    cnt = cnt + row + 1;
                } else {
                    row--;
                }
            }
            return cnt;
        }
    }
}
