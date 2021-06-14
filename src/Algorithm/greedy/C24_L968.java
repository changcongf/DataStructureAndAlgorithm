package Algorithm.greedy;

/**
 * @description：监控二叉树
 * @date ：2021/6/14 17:29
 */
public class C24_L968 {
    class Solution {
        int res = 0;

        public int minCameraCover(TreeNode root) {
            if (traversal(root) == 0) {
                res++;
            }
            return res;
        }

        public int traversal(TreeNode tree) {
            if (tree == null) return 2;
            int left = traversal(tree.left);
            int right = traversal(tree.right);

            if (left == 2 && right == 2) return 0;
            else if (left >= 1 && right >= 1) return 2;
            else {
                res++;
                return 1;
            }
        }
    }
}




class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
