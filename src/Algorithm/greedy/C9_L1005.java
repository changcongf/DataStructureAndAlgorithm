package Algorithm.greedy;

import java.util.Arrays;

/**
 * @description：K次取反后最大化数组和
 * @date ：2021/6/14 22:19
 */
public class C9_L1005 {
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            Arrays.sort(A);

            int i;
            for (i = 0; i < A.length && A[i] < 0 && K > 0; i++) {
                A[i] = -A[i];
                K--;
            }
            if (K > 0 && K % 2 == 1) {
                if (i == 0) A[i] = -A[i];
                else if (i == A.length) A[i-1] = -A[i-1];
                else if (A[i-1] > A[i]) A[i] = -A[i];
                else A[i-1] = -A[i-1];
            }
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += A[j];
            }
            return sum;
        }
    }
}
